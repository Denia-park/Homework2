import java.util.ArrayList;
import java.util.Scanner;

public class vendingMachine {
    private ArrayList<product> storage = new ArrayList<>();
    int balance = 0;

    product coke = new product("콜라",3,700);
    product water = new product("물",5,500);
    product orangeJuice = new product("오렌지 쥬스",7,1000);

    Scanner scan = new Scanner(System.in);
    String answer = null;

    vendingMachine()
    {
        addProdut(coke);
        addProdut(water);
        addProdut(orangeJuice);
    }

    void scanUserTypingAnswer() {
        answer = scan.next();
        scan.nextLine();
    }

    void abandonRestOfUserTypingAnswer() {
        scan.nextLine();
    }

    boolean addProdut(product productObject){
        return storage.add(productObject);
    }

    ArrayList<product> getList(){
        return storage;
    }

    void showProductList() {
        StringBuilder SB = new StringBuilder();
        System.out.println("\n");
        for (int i = 0; i < storage.size(); i++) {
            SB.append(i+1).append(".").append(storage.get(i).name).append(" (").append(storage.get(i).price).append("W) - ").append(storage.get(i).stock).append("   ");
        }
        System.out.println(SB.toString());
    }

    void showBalance() {
        StringBuilder SB = new StringBuilder();
        SB.append("\n현재 잔액 : ").append(balance);
        System.out.println(SB.toString());
    }

    void showUserMenuList() {
        StringBuilder SB = new StringBuilder();
        SB.append("\n메뉴를 선택해주세요 (숫자를 입력)").append("\n1.금액 추가 2.물품 구매 3.잔돈 반환 \n");
        System.out.println(SB.toString());
    }

}
