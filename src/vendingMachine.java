import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachine {
    private ArrayList<Product> storage = new ArrayList<>();
    final int USER_MODE = 0;
    final int ADMIN_MODE = 1;
    final int ADMIN_ENTER_BALANCE = 717942;

    int balance = 0;
    int income = 0;
    int mode = USER_MODE;

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

    void parsingUserAnswer(String userAnswer) {
        if (isEqual(userAnswer,UserMenuList.ADD_BALANCE)) {
            showMenuAddBalance();
        } else if (isEqual(userAnswer,UserMenuList.BUY_PRODUCT)) {
            showMenuBuyProduct();
        } else if (isEqual(userAnswer,UserMenuList.RETURN_BALANCE)) {
            showMenuReturnBalance();
        } else {
            System.out.println("잘못된 입력을 하셨습니다.\n");
        }
    }

    boolean isEqual(String userAnswer,UserMenuList userMenuList){
        return userAnswer.equals(Integer.toString(userMenuList.ordinal()+1));
    }

    boolean isEqual(String userAnswer,AdminMenuList adminMenuList){
        return userAnswer.equals(Integer.toString(adminMenuList.ordinal()+1));
    }

    void parsingAdminAnswer(String userAnswer) {
        if (isEqual(userAnswer, AdminMenuList.CHANGE_MENU)) {
            showMenuChangeMenu();
        } else if (isEqual(userAnswer, AdminMenuList.CHANGE_MENU_PRICE)) {
            showMenuChangeMenuPrice();
        } else if (isEqual(userAnswer, AdminMenuList.ADD_MENU_STOCK)) {
            showMenuAddMenuStock();
        } else if (isEqual(userAnswer, AdminMenuList.ADD_MENU)) {
            showMenuAddMenu();
        } else if (isEqual(userAnswer, AdminMenuList.GET_ALL_INCOME)) {
            showMenuGetAllIncome();
        } else if (isEqual(userAnswer, AdminMenuList.EXIT_ADMIN_MODE)) {
            showMenuExitAdminMode();
        } else {
            System.out.println("잘못된 입력을 하셨습니다.\n");
        }
    }
    
    void showMenuAddMenu(){
        String name = null;
        int stock = 0;
        int price = 0;

        System.out.println("메뉴 추가\n"); 

        System.out.println("추가할 음료의 이름을 입력해주세요.\n");
        name = scanUserTypingAnswer();

        while(true)
        {
            try {
                System.out.println("추가할 음료의 재고를 입력해주세요.\n");
                stock = Integer.parseInt(scanUserTypingAnswer());
                break;
            } catch (Exception e) {
                System.out.println("잘못된 입력을 하셨습니다. 다시 재고를 입력해주세요.\n");
            }
        }

        while(true)
        {
            try {
                System.out.println("추가할 음료의 가격을 입력해주세요.\n");
                price = Integer.parseInt(scanUserTypingAnswer());
                break;
            } catch (Exception e) {
                System.out.println("잘못된 입력을 하셨습니다. 다시 가격을 입력해주세요.\n");
            }
        }

        addProdut(new Product(name,stock,price));
    }

    void showMenuChangeMenuPrice(){
        int productNum = 0;
    
        System.out.println("메뉴 가격 변경\n");        

        try {
            System.out.println("변경할 음료를 선택해주세요. (숫자 입력)\n");
            productNum = Integer.parseInt(scanUserTypingAnswer());
            changeMenuPrice(productNum);
        } catch (Exception e) {
            System.out.println("잘못된 입력을 하셨습니다. 제품의 List를 다시 한번 확인해주세요\n");
        }
    }

    void changeMenuPrice(int productNum){

        while(true){
            try {
                System.out.println(storage.get(productNum - 1).name + " 의 가격을 얼마로 변경 하시겠습니까? \n");
                storage.get(productNum - 1).price = Integer.parseInt(scanUserTypingAnswer());
                break;
            } catch (Exception e) {
                System.out.println("잘못된 입력을 하셨습니다. 다시 가격을 입력해주세요.\n");
            }
        }
    }

    void showMenuChangeMenu(){
        int productNum = 0;

        System.out.println("메뉴 변경\n");        

        try {
            System.out.println("변경할 음료를 선택해주세요. (숫자 입력)\n");
            productNum = Integer.parseInt(scanUserTypingAnswer());
            changeMenu(productNum);
        } catch (Exception e) {
            System.out.println("잘못된 입력을 하셨습니다. 제품의 List를 다시 한번 확인해주세요\n");
        }
    }

    void changeMenu(int productNum){
        System.out.println(storage.get(productNum-1).name + " 의 이름을 무엇으로 변경 하시겠습니까? \n");
        storage.get(productNum-1).name = scanUserTypingAnswer();

        while(true){
            try {
                System.out.println(storage.get(productNum - 1).name + " 의 가격을 얼마로 변경 하시겠습니까? \n");
                storage.get(productNum - 1).price = Integer.parseInt(scanUserTypingAnswer());
                break;
            } catch (Exception e) {
                System.out.println("잘못된 입력을 하셨습니다. 다시 가격을 입력해주세요.\n");
            }
        }

        while(true){
            try {
                System.out.println(storage.get(productNum - 1).name + "의 재고를 몇개로 변경 하시겠습니까? \n");
                storage.get(productNum - 1).stock = Integer.parseInt(scanUserTypingAnswer());
                break;
            } catch (Exception e) {
                System.out.println("잘못된 입력을 하셨습니다. 다시 재고를 입력해주세요.\n");
            }
        }
    }

    void showMenuAddMenuStock(){
        int productNum = 0;

        System.out.println("재고 추가 메뉴\n");     

        try {
            System.out.println("변경할 음료를 선택해주세요. (숫자 입력)\n");
            productNum = Integer.parseInt(scanUserTypingAnswer());
            addStockOfProduct(productNum);
        } catch (Exception e) {
            System.out.println("잘못된 입력을 하셨습니다. 제품의 List를 다시 한번 확인해주세요\n");
        }
    }

    int getOriginalStock(int productNum){
        return storage.get(productNum-1).stock;
    }
    
    void addStockOfProduct(int productNum){
        int stockNumToAdd = 0;

        while(true){
            try {
                System.out.println(storage.get(productNum - 1).name + " 의 재고를 얼마나 추가 하시겠습니까? (숫자 입력)\n");
                stockNumToAdd = Integer.parseInt(scanUserTypingAnswer());
                storage.get(productNum-1).stock += stockNumToAdd;
                break;
            } catch (Exception e) {
                System.out.println("잘못된 입력을 하셨습니다. 다시 재고를 입력해주세요.\n");
            }
        }
    }

    void showMenuExitAdminMode(){
        System.out.println("관리자 메뉴를 나갑니다.\n");
        mode = USER_MODE;
    }

    void showMenuGetAllIncome(){
        System.out.println("지금까지 총 수익 : "+ income);
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
        if (balanceToAdd == ADMIN_ENTER_BALANCE) {
            mode = ADMIN_MODE;
        }
        else{
            addBalance(balanceToAdd);
        }
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
            income += storage.get(productNumToBuy).price;
            storage.get(productNumToBuy).stock--;

            System.out.println(storage.get(productNumToBuy).name + " 가(이) 나왔습니다!\n");
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
        StringBuilder sb = new StringBuilder();
        System.out.println("음료수 자판기 입니다. ※UI 구성 : 번호.상품명 (가격W) - 재고\n");

        for (int i = 0; i < storage.size(); i++) {
            sb.append(i + 1).append(".").append(storage.get(i).name).append(" (").append(storage.get(i).price)
                    .append("W) - ").append(storage.get(i).stock).append("   ");
        }
        System.out.println(sb.toString());
    }

    void showBalance() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n현재 잔액 : ").append(balance);
        System.out.println(sb.toString());
    }

    void showUserMenuList() {
        System.out.println("\n메뉴를 선택해주세요 (숫자를 입력)\n1.금액 추가 2.물품 구매 3.잔돈 반환 \n");
    }

    void showAdminMenuList() {
        System.out.println("\n관리자 메뉴에 오셨습니다. \n");
        System.out.println("메뉴를 선택해주세요 (숫자를 입력)\n1.메뉴 변경 2.메뉴 가격 변경 3.메뉴 재고 추가 4.메뉴 추가 5.총 수입 확인 6. 관리자 메뉴 종료\n");
    }

}
