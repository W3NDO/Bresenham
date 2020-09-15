import java.awt.Component; 
import java.awt.Color; 
import java.awt.Graphics; 
import java.awt.Graphics2D; 
import java.util.Random;
import java.lang.*;

public class drawLine extends Component{
    int start_x, start_y, end_x, end_y;
    String line_type;
    
    public drawLine(int x1, int y1, int x2, int y2, String lineType){
        this.start_x = x1;
        this.start_y = y1;
        this.end_x = x2;
        this.end_y =y2;
        this.line_type = lineType;
    }

    public void paint(Graphics g) { 
        int delta_x = Math.abs(end_x-start_x);
        int delta_y = Math.abs(end_y-start_y);
        int step_x = (start_x < end_x)? 1 : -1;
        int step_y = (start_y < end_y)? 1 : -1;
        int err = delta_x - delta_y;
        
        int p0 = 2 * delta_y - delta_x, p1;    
        
        switch(line_type){
            case "solid":    
                for(int k = 1; k <= delta_x; k++) {
                    if(p0 < 0) {
                        p1 = p0 + (2 * delta_y);
                    step_x++;
                    } else {
                        p1 = p0 + (2 * delta_y) - (2 * delta_x);
                        step_x++;
                        step_y++;
                    }
                Graphics2D g2d = (Graphics2D) g;
                g.setColor(Color.RED);
                g.drawLine(step_x,step_y,step_x+1,step_y+1);
                }
                break;
            case "dotted":    
                for(int k = 1; k <= delta_x; k++) {
                    int temp_x = step_x;
                    int temp_y = step_y;
                    if(p0 < 0) {
                        p1 = p0 + (2 * delta_y) + 2;
                    step_x++;
                    } else {
                        p1 = p0 + (2 * delta_y) - (2 * delta_x) +2;
                        step_x+=3;
                        step_x+=3;
                        step_y+=3;
                        step_y+=3;
                    }

                    Graphics2D g2d = (Graphics2D) g;
                    g.setColor(Color.BLUE);
                    for(int i =0; i<2; i++){
                        g.drawLine(step_x, step_y, step_x+1,step_y+1);
                    }                }
                break;
            case "dashed":  
                boolean stroke = true;
                int count = 0;
                for(int k = 1; k <= delta_x; k++) {
                    if(p0 < 0) {
                        p1 = p0 + (2 * delta_y);
                    step_x+=1;
                    } else {
                        p1 = p0 + (2 * delta_y) - (2 * delta_x);
                        step_x +=5;
                        step_y +=5;
                    }
                    count++;
                    Graphics2D g2d = (Graphics2D) g;
                    g.setColor(Color.BLACK);
                    for(int i =0; i<2; i++){
                        g.drawLine(step_x, step_y, step_x+3,step_y+3);
                    }
                }
                break;
            default:
                g.setColor(Color.GREEN);
                g.drawLine(0,120,120,120);
                break;
        }
    }
}
