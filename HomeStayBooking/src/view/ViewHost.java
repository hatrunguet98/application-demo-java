package view;

import model.saleitem.typeitem.SaleItem;
import model.user.User;
import service.dao.SaleItemFile;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewHost {
    private User host;

    public ViewHost(User host) {
        this.host = host;
    }


    public void viewHost(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Show list sale item : 1\n");
        System.out.printf("Show list booking   : 2 \n");
        if(scanner.nextLine().equals("1")){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            this.showSaleItem(this.host.getId());
        }
    }
    private void showSaleItem(String idHost){
        ArrayList<SaleItem> listSlaeItem = new SaleItemFile().get();
        for (int i = 0; i < listSlaeItem.size(); i++) {
            if (listSlaeItem.get(i).getIdHost()==idHost) {
                listSlaeItem.get(i).toString();
            }
        }
        System.out.printf("Sort by price :1 \n");
        System.out.printf("Sort by issue date :2 \n");
    }
}
