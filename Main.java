import java.util.*; 

class Main {
  public static void main(String[] args) {
    int frameWidth = 500; 
    int frameHeight = 500; 
    javax.swing.JFrame frame = new javax.swing.JFrame(); 
    frame.setSize(frameWidth, frameHeight); frame.setVisible(true);
    frame.getContentPane().add(new drawLine(0,0,120,120,"dotted")); //the last parameter can either be "dotted", "solid" or "dashed"
  }

}
