import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SimpleCollectorMap<T> {

	static Predicate<List<Member>> NullOfException = (t1) -> !(t1.size() > 0)  ;

	public static void main(String[] args) throws Exception {

		List<Member> members = new ArrayList<>();
//		Member member = new Member();
//		member.setMemNo(1);
//		compateItems.add(member);

		if( NullOfException.test(members))
			throw new Exception("Invalid membeNO not-found");


		//Old Code
//		Optional.of(compateItems)
//		               .filter(elem -> !CollectionUtils.isEmpty(elem))
//		        .orElseThrow(() -> new Exception("멤버 넘버  가 존재 하지 않습니다."));


	}
}

class Member {
	private int memNo;
	private String name;

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
