import java.util.ArrayList;
import java.util.List;

public class SalesPromotionRepositoryTestImpl implements SalesPromotionRepository {

    private ItemRepository itemRepository = new ItemRepositoryTestImpl();

    @Override
    public List<SalesPromotion> findAll() {
        return TestData.ALL_SALES_PROMOTIONS;
    }


    /**
     * Calculating the Best Preferences
     * @param items, sum
     * @author Dean Huang
     */
    @Override
    public ArrayList bestCharge(ArrayList<Item> items,double sum){
        //TODO: Add Elemnet not found Exception
        Item item1 = itemRepository.getItemById("ITEM0001");
        Item item2 = itemRepository.getItemById("ITEM0022");
        double charge1Sum = 0;
        //菜品半价优惠计算
        for(Item item: items){
            if(item.getId().equals(item1.getId()) || item.getId().equals(item2.getId())){
                charge1Sum += item.getPrice() / 2;
            }else{
                charge1Sum += item.getPrice();
            }
        }
        //满30减6元计算
        double charge2Sum = sum - (int)sum / 30 * 6;
        //list.get(0)——优惠结果显示
        //list.get(1)——应付价格
        //list.get(2)——优惠价格
        ArrayList list = new ArrayList();
        if(charge1Sum <= charge2Sum){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("(");
            if(items.contains(item1)){
                stringBuilder.append(item1.getName());
            }
            if(stringBuilder.toString().length() > 0){
                stringBuilder.append("，");
            }
            if(items.contains(item2)){
                stringBuilder.append(item2.getName());
            }
            stringBuilder.append(")");
            list.add(TestData.ALL_SALES_PROMOTIONS.get(1).getDisplayName() + stringBuilder.toString());
            list.add((int)charge1Sum);
        }else{
            list.add(TestData.ALL_SALES_PROMOTIONS.get(0).getDisplayName());
            list.add((int)charge2Sum);
        }
        list.add((int)(sum - (charge1Sum <= charge2Sum ? charge1Sum : charge2Sum)));
        return list;
    }
}
