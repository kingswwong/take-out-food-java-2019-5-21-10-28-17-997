import java.util.List;


public class ItemRepositoryTestImpl implements ItemRepository{
    @Override
    public List<Item> findAll() {
        return TestData.ALL_ITEMS;
    }


    /**
     * Find Item by Id
     * @param id
     * @author Dean Huang
     */
    @Override
    public Item getItemById(String id) {
        //TODO: Add Elemnet not found Exception
        for(Item item: TestData.ALL_ITEMS){
            if (item.getId().equals(id)){
                return item;
            }
        }
        return null;
    }
}
