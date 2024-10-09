import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Candlestick {

    private Long openTime;

    private double open;

    private double high;

    private double low;

    private double close;

    private double volume;

    private Long closeTime;

    public Long getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Long openTime) {
        this.openTime = openTime;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = toDouble(open);
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = toDouble(high);
    }

    public double getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = toDouble(low);
    }

    public double getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = toDouble(close);
    }

    public Long getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Long closeTime) {
        this.closeTime = closeTime;
    }


    public LocalDateTime getFormattedOpenTime() {
        return Instant.ofEpochMilli(openTime).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public LocalDateTime getFormattedCloseTime() {
        return Instant.ofEpochMilli(closeTime).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public double toDouble(String a) {
        return Double.parseDouble(a);
    }


}