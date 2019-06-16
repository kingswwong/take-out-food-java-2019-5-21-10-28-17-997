import java.util.ArrayList;
import java.util.List;

public interface SalesPromotionRepository {
    List<SalesPromotion> findAll();

    ArrayList bestCharge(ArrayList<Item> items, double sum);
}
