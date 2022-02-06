import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachine {
    private ArrayList<Product> storage = new ArrayList<>();
    int balance = 0;

    Product coke = new Product("콜라", 0, 700);
    Product water = new Product("물", 5, 500);
    Product orangeJuice = new Product("오렌지 쥬스", 7, 1000);

    Scanner scan = new Scanner(System.in);
    String answer = null;

    VendingMachine() {
        addProdut(coke);
        addProdut(water);
        addProdut(orangeJuice);
    }

    String scanUserTypingAnswer() {
        answer = scan.next();
        scan.nextLine();

        return answer;
    }

    void parsingUserAnswer(String UserAnswer) {
        String ADD_BALANCE = "1";
        String BUY_PRODUCT = "2";
        String RETURN_BALANCE = "3";

        if (UserAnswer.equals(ADD_BALANCE)) {
            showMenuAddBalance();
        } else if (UserAnswer.equals(BUY_PRODUCT)) {
            showMenuBuyProduct();
        } else if (UserAnswer.equals(RETURN_BALANCE)) {
            showMenuReturnBalance();
        } else {
            System.out.println("잘못된 입력을 하셨습니다.\n");
        }
    }

    void showMenuAddBalance() {
        int balanceToAdd = 0;
        System.out.println("추가할 금액을 입력해주세요.\n");
        try {
            balanceToAdd = Integer.parseInt(scanUserTypingAnswer());
            System.out.println("잔액을 추가했습니다.\n");
        } catch (Exception e) {
            System.out.println("잘못된 입력을 하셨습니다.\n");
            balanceToAdd = 0;
        }
        addBalance(balanceToAdd);
    }

    void showMenuReturnBalance() {
        System.out.println("잔돈을 반환했습니다.\n");
        clearBalance();
    }

    void showMenuBuyProduct() {
        int productNumToBuy = 0;
        System.out.println("구매할 제품의 번호를 입력해주세요.\n");
        try {
            productNumToBuy = Integer.parseInt(scanUserTypingAnswer());
            buyProduct(productNumToBuy-1);
        } catch (Exception e) {
            System.out.println("잘못된 입력을 하셨습니다. 제품의 List를 다시 한번 확인해주세요\n");
        }
    }

    void buyProduct(int productNumToBuy) {
        if (storage.get(productNumToBuy).stock <= 0) {
            System.out.println("재고가 부족합니다. 죄송합니다.\n");

            return;
        }

        if (balance >= storage.get(productNumToBuy).price) {
            balance -= storage.get(productNumToBuy).price;
            storage.get(productNumToBuy).stock--;

            System.out.println(storage.get(productNumToBuy).name + "가(이) 나왔습니다!\n");
        }
        System.out.println("금액이 부족합니다. 금액을 추가해주세요.\n");
    }

    void addBalance(int balanceToAdd) {
        balance += balanceToAdd;
    }

    void clearBalance() {
        balance = 0;
    }

    void abandonRestOfUserTypingAnswer() {
        scan.nextLine();
    }

    boolean addProdut(Product productObject) {
        return storage.add(productObject);
    }

    ArrayList<Product> getList() {
        return storage;
    }

    void showProductList() {
        StringBuilder SB = new StringBuilder();
        System.out.println("음료수 자판기 입니다. ※UI 구성 : 번호.상품명 (가격W) - 재고\n");

        for (int i = 0; i < storage.size(); i++) {
            SB.append(i + 1).append(".").append(storage.get(i).name).append(" (").append(storage.get(i).price)
                    .append("W) - ").append(storage.get(i).stock).append("   ");
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
