package main.pojo;

public class Snake extends Jumper {
    public Snake(int start, int end) throws Exception {
        super(start, end);
        if(start<=end)
            throw new Exception("Invalid request");
    }
}
