public class Stopwatch extends Thread
{
    //public int seconds = 1, minutes = 1;
    public int seconds, minutes, hundredthes;
    public Stopwatch()
    {
        this.seconds = 0;
        this.minutes = 0;
        this.hundredthes = 0;
    }

    public void reset()
    {
        this.seconds = 0;
        this.minutes = 0;
        this.hundredthes = 0;
    }

    public void run()
    {
        while(true)
        {
            this.increment();
            //this.print();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            

        }
    }

    public void increment()
    {
        this.hundredthes++;
        if(this.hundredthes == 100)
        {
            this.hundredthes = 0;
            this.seconds++;
        }
        if(this.seconds == 60)
        {
            this.seconds = 0;
            this.minutes++;
        }
    }

    public void print()
    {
        System.out.println(String.format("%02d", this.minutes) + ":" + String.format("%02d", this.seconds) + ":" + String.format("%02d", this.hundredthes));
    }

}
