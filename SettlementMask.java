import com.trimplement.wallet.server.common.dom.InvalidInputException;
public class SettlementMask {
    
        public final static short publicIdVersion = 1;
        public final  static long publicIdXor = 603259041168L;
        public final  static String publicIdHashPrefix = "b93cdcf26f01b59b5ce41802197178ef43de6bbb";
        public final  static String publicIdHashPostfix = "20a801e2803ccfa097b49191eba519d167dd350a";
        public final static InvalidInputException.FieldBase fieldBase = InvalidInputException.Field.Settlement;
        public final  static String typedIdType = "Settlement";//TypedIdConstants.TYPE_SETTLEMENT.toString();
    
    
}
