public class MainApp {
    public static void main(String[] args) throws Exception {
        VendingMachine beverageSeller = new VendingMachine();

        while (true) {
            beverageSeller.showProductList();
            beverageSeller.showBalance();
            beverageSeller.showUserMenuList();

            beverageSeller.parsingUserAnswer(beverageSeller.scanUserTypingAnswer());
            

        }

    }
}
