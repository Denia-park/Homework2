public class mainApp {
    public static void main(String[] args) throws Exception {
        vendingMachine beverageSeller = new vendingMachine();

        System.out.println("음료수 자판기 입니다. ※UI 구성 : 번호.상품명 (가격W) - 재고");
        beverageSeller.showProductList();
        beverageSeller.showBalance();
        beverageSeller.showUserMenuList();
        beverageSeller.scanUserTypingAnswer();
    }
}
