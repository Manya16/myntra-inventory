package microservice.example.myntrainventory.service.common;

public class MyntraUtils {

    public static String getItemCode(Integer productId) {
        StringBuffer itemCode = new StringBuffer("PRD");

        String prodId = productId + "";
        Integer suffixLen = prodId.length();
        Integer numOfZeros = 9 - suffixLen;

        for (int i = 0; i < numOfZeros; i++) {
            itemCode = itemCode.append("0");
        }

        itemCode = itemCode.append(prodId);
        return itemCode.toString();
    }
}
