package Common;

public class EstimateCode {
    private double start;
    private double end;
    private double estimatedTime;
    private double KByte;
    private double MByte;
    private long bytes;

    public void start(){
        this.start = System.currentTimeMillis();
    }

    public void end(){
        this.end = System.currentTimeMillis();
        this.estimatedTime = (this.end - this.start) / 1000.0;

        Runtime.getRuntime().gc();
        this.bytes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        this.KByte = Math.floor(this.bytes / 1024);
        this.MByte = Math.floor(this.KByte / 1024);
        print();
    }

    void print(){
        System.out.println();
        System.out.println("##############");
        System.out.println("사용된 메모리: " + this.bytes + "bytes");
        System.out.println("사용된 메모리: " + this.KByte + "KB");
        System.out.println("사용된 메모리: " + this.MByte + "MB");
        System.out.println("소요 시간   : " + this.estimatedTime + "초");
        System.out.println("##############");
    }
}
