package springboot;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;

import java.net.SocketTimeoutException;

@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("local")
@Slf4j
@EnableCircuitBreaker
class UniversePassApiServiceImplTest {

    @Autowired
    private DummyHystrixCommand dummyHystrixCommand;


    @Test
    void testHystrixCommandActived() throws InterruptedException {
        for(int i =0; i < 50; i ++) {
            dummyHystrixCommand.getMyPackageName(i);
            Thread.sleep(500L);
        }
    }

    @TestConfiguration
    static class testConfiguration{
        @Bean
        public DummyHystrixCommand dummyHystrixCommand(){
            return new DummyHystrixCommand();
        }
    }

}

/**
 * NOTE: getMyPackageName()은 기본 2초 timeout을 가지고 있으며(universePass Apitimeout 보고)
 * 1. 에러율이 10%, 요청 에러가 1개 이상이면 5초 기다리고 서킷브레이커를 열지/말지 2초마다 판단한다.
 */
class DummyHystrixCommand {
    @HystrixCommand(fallbackMethod = "fallbackMyPackageName",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"), //Hystrix 가 적용된 메서드의 타임아웃
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "5000"), //서킷 브레이커가 열리기위한 조건
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "10"), //서킷 브레이커가 발동할 에러 퍼센트를 지정한다. 기본값은 50
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "1"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000") //서킷 브레이커가 열렸을때 얼마나 지속될지를 설정한다. 기본값은 5초(5000)
            })
    public void getMyPackageName(int count){
        if( count % 5 == 0 ) {
            try {
                Thread.sleep(40000L);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                try {
                    throw new SocketTimeoutException("Socket Read-Timeout");
                } catch (SocketTimeoutException ex) {
                }
            }
        }else {
            System.out.println("Success Service " + count);
        }
    }

    private void fallbackMyPackageName(int count){
        System.out.println("circuitBreaker Open! " + count);
    }
}
