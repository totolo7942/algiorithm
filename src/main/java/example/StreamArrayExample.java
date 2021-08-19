//package example;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.function.Function;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;
//
//import static java.util.Collections.EMPTY_LIST;
//
//
//
//public class StreamArrayExample {
//
//    public static void main(String[] args) {
//        List<String> params  = Arrays.asList("shBuyerType", "shBuyerText", null, "shRsnCode");
//
//        buildRequestParameters("1", "2", "4");
//
//    }
//
//    static List<String> buildRequestParameters(String ... queryParameters) {
////        List<String> parameters = Arrays.stream(queryParameters)
////                .filter(r -> !StringUtils.isEmpty(r))
////                .map(r -> {
////                    try {
////                        return URLDecoder.decode(r, StandardCharsets.UTF_8.toString());
////                    } catch (UnsupportedEncodingException e) {
////                        e.printStackTrace();
////                    }
////                    return r;
////                }).collect(Collectors.toList());
//
//        EscrowSearchBO paramBO = new EscrowSearchBO();
//
//        Optional.ofNullable(paramBO).map(
//                v -> {
//                    paramBO.setV1(queryParameters[0]);
//                    paramBO.setV2(queryParameters[1]);
//                    paramBO.setV3(queryParameters[2]);
//                    paramBO.setV4(queryParameters[3]);
//                    return paramBO;
//                }
//        );
//
//        Arrays.stream(queryParameters).collect( EscrowSearchBO::new, (o, s) -> {
//
//        })
//
//
//        System.out.printf( String.format("#>>>> %s %s %s %s ", paramBO.getV1(), paramBO.getV2(), paramBO.getV3(), paramBO.getV4()));
//
//        return EMPTY_LIST;
//    }
//
//    static EscrowSearchBO mapToObject(EscrowSearchBO bo, String value, Integer idx) {
//        EscrowSearchBO searchBO = new EscrowSearchBO();
//        switch(idx) {
//            case 0:
//                searchBO.setV1(value);
//                break;
//        }
//
//        return bo;
//    }
//}
//
//class StringUtils {
//
//    public static boolean isEmpty(String r ) {
//        return Objects.isNull(r);
//    }
//}
//
//
//class EscrowSearchBO {
//    private String  v1;
//    private String  v2;
//    private String  v3;
//    private String  v4;
//
//    public String getV1() {
//        return v1;
//    }
//
//    public void setV1(String v1) {
//        this.v1 = v1;
//    }
//
//    public String getV2() {
//        return v2;
//    }
//
//    public void setV2(String v2) {
//        this.v2 = v2;
//    }
//
//    public String getV3() {
//        return v3;
//    }
//
//    public void setV3(String v3) {
//        this.v3 = v3;
//    }
//
//    public String getV4() {
//        return v4;
//    }
//
//    public void setV4(String v4) {
//        this.v4 = v4;
//    }
//
//    public EscrowSearchBO(String v1, String v2, String v3, String v4) {
//        this.v1 = v1;
//        this.v2 = v2;
//        this.v3 = v3;
//        this.v4 = v4;
//
//    }
//
//    public EscrowSearchBO() {
//
//    }
//}
