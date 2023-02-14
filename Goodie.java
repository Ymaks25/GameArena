

public class Goodie{
    private static final int rectNum = 18;
    private static final int rectSize = 10;
    private double x;
    private double y;
    private Rectangle[] rectangles;

    public Goodie(){
        this.x = 100;
        this.y = 375;
        this.rectangles = new Rectangle[rectNum];
        initRectangles();
    }
    
    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public Rectangle[] getRectangles(){
        return this.rectangles;
    }

    public void addTo(GameArena arena){
        for(int i=0;i<rectNum;i++){
            arena.addRectangle(this.rectangles[i]);
        }
    }

    public void initRectangles(){
        rectangles[0] = new Rectangle(x+rectSize, y, rectSize, rectSize, "WHITE", 1);
        rectangles[15] = new Rectangle(x, y, rectSize, rectSize, "WHITE", 1);
        rectangles[16] = new Rectangle(x, y-rectSize, rectSize, rectSize, "WHITE", 1);
        rectangles[17] = new Rectangle(x, y-2*rectSize, rectSize, rectSize, "GREY", 1);
        rectangles[1] = new Rectangle(x+2*rectSize, y, rectSize, rectSize, "WHITE", 1);
        rectangles[2] = new Rectangle(x+2*rectSize, y+rectSize, rectSize, rectSize, "WHITE", 1);
        rectangles[3] = new Rectangle(x+2*rectSize, y+2*rectSize, rectSize, rectSize, "GREY", 1);
        rectangles[4] = new Rectangle(x+3*rectSize, y, rectSize, rectSize, "WHITE", 1);
        rectangles[5] = new Rectangle(x+4*rectSize, y, rectSize, rectSize, "WHITE", 1);
        rectangles[6] = new Rectangle(x+5*rectSize, y, rectSize, rectSize, "WHITE", 1);
        rectangles[7] = new Rectangle(x+5*rectSize, y+rectSize, rectSize, rectSize, "WHITE", 1);
        rectangles[8] = new Rectangle(x+5*rectSize, y+2*rectSize, rectSize, rectSize, "GREY", 1);
        rectangles[9] = new Rectangle(x+6*rectSize, y, rectSize, rectSize, "WHITE", 1);
        rectangles[10] = new Rectangle(x+6*rectSize, y-rectSize, rectSize, rectSize, "WHITE", 1);
        rectangles[11] = new Rectangle(x+7*rectSize, y-rectSize, rectSize, rectSize, "GREEN", 1);
        rectangles[12] = new Rectangle(x+7*rectSize, y-2*rectSize, rectSize, rectSize, "WHITE", 1);
        rectangles[13] = new Rectangle(x+7*rectSize, y, rectSize, rectSize, "WHITE", 1);
        rectangles[14] = new Rectangle(x+8*rectSize, y, rectSize, rectSize, "RED", 1);
    }

    public void jump(){
        while(true){
            for(int j = 0;j < 45000000;j++){
                for (int i = 0;i < rectNum; i++){
                    rectangles[i].setYPosition(rectangles[i].getYPosition()-0.000003);
                }
            }
            for(int j = 0;j < 45000000;j++){
                for (int i = 0;i < rectNum; i++){
                    rectangles[i].setYPosition(rectangles[i].getYPosition()+0.000003);
                }
            }
        }
    }




}