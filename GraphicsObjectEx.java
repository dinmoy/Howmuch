package JavaProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//명품 자바 12장 6번 파이그래프 그리기 예제
public class GraphicsObjectEx extends How_much2{
	
	JFrame Frame=new JFrame("static");
	private static final String Int = null;
	LocalDate now = LocalDate.now();
	int year = now.getYear();
	int month = now.getMonthValue();
	int day=now.getDayOfMonth();
	String[] months = {"월"};
	Container contentPane; // 컨테이너 생성
	int[] data = {0,0,0,0,0,0};// 차트의 값 저장배열
	int[] arcAngle = new int[6]; 
	Color[] color = {Color.RED, Color.BLUE, Color.MAGENTA, Color.ORANGE,Color.yellow,Color.GREEN};
	String[] itemName = {"교통비", "기타","식비", "여가생활","의류","저축"};
	JTextField[] tf  = new JTextField[6]; // 텍스트필드
	JTextField[] txt=new JTextField[1];
	ChartPanel chartPanel = new ChartPanel(); // 차트패널
   
    //https://bibi6666667.tistory.com/203
	public GraphicsObjectEx() throws SQLException{ // 생성자
		setTitle("그래픽 그래프");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = Frame.getContentPane(); // 컨테이너 갯
		contentPane.add(new InputPanel(), BorderLayout.NORTH);
		contentPane.add(chartPanel, BorderLayout.CENTER);
		
		
		Frame.setSize(840,640);
		Frame.setVisible(true);
		Frame.setLocationRelativeTo(null);
		Frame.setResizable(false);
		drawChart(); // 차트 메소드 호출
	}

	int i,n=1;
	// 차트를 그리기
	void drawChart() throws SQLException{ 
		int sum=0; 
		try (var rs=getResulSet("SELECT  i_id=?,SUM(i_price) FROM info GROUP BY i_category ORDER BY i_category ASC",user)){
			while(rs.next()) {
				data[0]=rs.getInt(2);
				data[1]=rs.getInt(2); 
				data[2]=rs.getInt(2); 
				data[3]=rs.getInt(2);
				data[4]=rs.getInt(2);
				data[5]=rs.getInt(2);
			}
			System.out.println(data[0]+data[1]+data[2]+data[3]+data[4]+data[5]);
			System.out.println("실행성공"); 
		}catch(Exception e) { e.printStackTrace(); }
		for(i=0;i<data.length;i++) {
			sum+=data[i];
		}	
		if(sum == 0) 
			return;

		for(int i=0;i<data.length;i++){ 
			arcAngle[i] = (int)Math.round((double)data[i]/(double)sum*360);
			chartPanel.repaint(); // 차트패널의 PAINT호출
		}
	}
	class InputPanel extends JPanel{ 
		public InputPanel(){
			this.setBackground(Color.pink); 
 
			for(int i=0;i<1;i++){ 
				txt[i] = new JTextField(" ",7);
				add(txt[i]);
				add(new JLabel(months[i]));
				
				
			}
		}
	}


	//https://bibi6666667.tistory.com/199
	// 차트 표시 패널
	class ChartPanel extends JPanel{ 

		public void paintComponent(Graphics g){

			//부모 패인트호출
			super.paintComponent(g);

			int startAngle = 0;

			for(int i=0;i<data.length;i++){
				g.setColor(color[i]);
				g.drawString(itemName[i]+""+Math.round(arcAngle[i]*100/360)+"%", 150+i*100,80);
			}

			//그래프
			for(int i=0;i<data.length;i++){
				g.setColor(color[i]);
				g.fillArc(230,100,400,400,startAngle,arcAngle[i]);
				startAngle = startAngle + arcAngle[i];
			}
		}
	}

	public static void main(String[] args) {
		try {
			new GraphicsObjectEx();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}