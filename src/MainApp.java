public class MainApp {
    public static void main(String[] args) throws Exception {
        VendingMachine beverageSeller = new VendingMachine();

        while (true) {
            beverageSeller.showProductList();

            if(beverageSeller.mode == beverageSeller.USER_MODE)
            {
                beverageSeller.showBalance();
                beverageSeller.showUserMenuList();
                
                beverageSeller.parsingUserAnswer(beverageSeller.scanUserTypingAnswer());
            }
            else if(beverageSeller.mode == beverageSeller.ADMIN_MODE)
            {
                beverageSeller.showAdminMenuList();

                beverageSeller.parsingAdminAnswer(beverageSeller.scanUserTypingAnswer());
            }
            

        }

    }
}
