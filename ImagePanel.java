package JavaProject;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
//https://www.youtube.com/watch?v=QjmhiS8lw24
//패널에 그림을 올려주는 클래스
public class ImagePanel extends JPanel {
	private Image img;
	
	public ImagePanel(Image img) {
		//img는 멤버변수
		this.img=img;
		//패널을 사용할 때는 preferredsize를 써야함.이미지 자체의 가로와 세로
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setLayout(null);
	}
	
	//그래픽 g: 이미지를 만드는 것
	public void paintComponent(Graphics g) {
		g.drawImage(img,0,0,null);
	}

}
