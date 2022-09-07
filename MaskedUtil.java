
//import org.apache.logging.log4j.core.async.ThreadNameCachingStrategy;

import com.trimplement.wallet.server.common.dom.WalletException;
import com.trimplement.wallet.server.common.service.PublicIdUtil;
/* 
import at.favre.lib.idmask.Config;
import at.favre.lib.idmask.IdMask;
import at.favre.lib.idmask.IdMasks;
import at.favre.lib.bytes.Bytes;
*/
class MaskedUtil {
    public static void main(String[] args) {
        try {
            MaskedUtil util=new MaskedUtil();
            long settlementID =util.getJumiaInternalId("AAEAAACMdQr-KifibTM3A0BdHdOVCQyEOB5aqqjzpiL9uSdBCcl_uWHp");
            
            System.out.println(settlementID);
            String publicId=util.getZenithPublicIdV2(settlementID);
            
            System.out.println(publicId);
            System.out.println(publicId.length());

            /*publicId=util.getZenithPublicId(100000000);
            
            System.out.println(publicId);
            System.out.println(publicId.length());
*/
             publicId=util.getZenithPublicIdV2(100000000);
            
            System.out.println(publicId);
            System.out.println(publicId.length());

        } catch (Exception e) {
             System.out.println(e.toString());

        }
   
    }
    public MaskedUtil(){

    }

    public long getJumiaInternalId(String input) throws WalletException{
        PublicIdUtil publicIdUtil = new PublicIdUtil(
            SettlementMask.publicIdVersion,
            SettlementMask.publicIdXor,
            SettlementMask.publicIdHashPrefix,
            SettlementMask.publicIdHashPostfix,
            SettlementMask.fieldBase,
            SettlementMask.typedIdType);
          
            return publicIdUtil.toId(input);

    }
    /*public String getZenithPublicId(long input) throws Exception{
        byte[] KEY = Bytes.parseHex("a3a5a7a9a1a0abea7aa8aaa3afaaaaaa").array();
        IdMask<Long> idMask = IdMasks.forLongIds(Config.builder(KEY).randomizedIds(true).build());

        String maskedId = idMask.mask(input);
        if (input!=idMask.unmask(maskedId)) 
            throw new Exception ("Error unmasking");
        return maskedId;

    }*/

    public String getZenithPublicIdV2(long input) throws Exception{
        PublicIdUtil publicIdUtil = new PublicIdUtil(
            SettlementMask.publicIdVersion,
            SettlementMask.publicIdXor,
            SettlementMask.publicIdHashPrefix,
            SettlementMask.publicIdHashPostfix,
            SettlementMask.fieldBase,
            SettlementMask.typedIdType);
            publicIdUtil.setSystemChecksumSize(24);
            return publicIdUtil.toPublicId(input);
    }

}