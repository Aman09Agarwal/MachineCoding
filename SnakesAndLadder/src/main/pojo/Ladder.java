package main.pojo;

public class Ladder extends Jumper{
    public Ladder(int start, int end) throws Exception {
        super(start, end);
        if(start>=end)
            throw new Exception("Invalid request");
    }
}
