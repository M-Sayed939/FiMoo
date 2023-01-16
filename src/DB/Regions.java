package DB;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import DB.Model.Region;
import DB.Services.*;

public class Regions {


        static Scanner input;
        static DataBaseClient db;
        public static void main(String[] args) throws SQLException {
            input = new Scanner(System.in);
            db = new DataBaseClient();
//        0 = exit
//        1 = select all
//        2 = select by id and get values
//        3 = insert and get values
//        4 = delete by Id and get values
//        5 = update by id and get values
            int operation ;
            while((operation = input.nextInt()) != 0){
                switch (operation){
                    case 1:
                        handleSelectAll();
                        break;
                    case 2 :
                        handleSelectById();
                        break;
                    case 3 :
                        handleInsert();
                        break;
                    case 4:
                        handleDeleteById();
                        break;
                    case 5:
                        handleUpdateById();
                        break;
                }
            }
        }

        private static void handleUpdateById() throws SQLException {
            int regionId = input.nextInt();
            String regionName = input.next();
            Region region = new Region();
            region.setRegionId(regionId);
            region.setRegionName(regionName);
            db.updateRegionById(region);
        }

        private static void handleDeleteById() throws SQLException {
            int id = input.nextInt();
            db.deleteRegionById(id);
        }

        private static void handleInsert() throws SQLException {
            int regionId = input.nextInt();
            String regionName = input.next();
            Region region = new Region();
            region.setRegionId(regionId);
            region.setRegionName(regionName);
            db.insertRegion(region);

        }

        private static void handleSelectById() {
            int id = input.nextInt();
            System.out.println(db.getRegionById(id));
        }


        private static void handleSelectAll() {
            List<Region> regionsList = db.getAllRegion();
            for(Region region : regionsList){
                System.out.println(region);
            }
        }
    }


