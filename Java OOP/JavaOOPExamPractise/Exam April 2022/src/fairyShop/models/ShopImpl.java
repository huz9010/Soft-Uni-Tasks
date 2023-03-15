package fairyShop.models;

import java.util.List;
import java.util.stream.Collectors;

public class ShopImpl implements Shop {

    @Override
    public void craft(Present present, Helper helper) {
        List<Instrument> instruments = helper.getInstruments().stream().collect(Collectors.toList());
        int start = 0;
        while (!present.isDone() && helper.canWork()) {
            if (instruments.get(start).isBroken()) {
                start++;
            }
            if (start >= instruments.size())    {
                break;
            }
            instruments.get(start).use();
            helper.work();
            present.getCrafted();
        }
    }

}
