public class CurrencyConverter implements CurrencyService{
    @Override
    public double getConverter(CurrencyType from, CurrencyType to) {
        double converter = 1;
        if(from == to) {
            converter = 1;
        }
        else if(from == CurrencyType.DOLLAR && to == CurrencyType.EURO) {
            converter = 1.15;
        }
        else if(from == CurrencyType.DOLLAR && to == CurrencyType.POUND) {
            converter = 1.31 ;
        }
        else if(from == CurrencyType.EURO && to == CurrencyType.DOLLAR) {
            converter = 0.87 ;
        }
        else if(from == CurrencyType.EURO && to == CurrencyType.POUND) {
            converter = 1.14 ;
        }
        else if(from == CurrencyType.POUND && to == CurrencyType.DOLLAR) {
            converter = 0.76 ;
        }
        else if(from == CurrencyType.POUND && to == CurrencyType.EURO) {
            converter = 0.88 ;
        }
        return converter;
    }

    public double convert(CurrencyType from, CurrencyType to, double amount){
        return getConverter(from, to)*amount;
    }
}
