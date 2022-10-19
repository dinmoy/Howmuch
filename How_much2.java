package JavaProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class How_much2 {
	JFrame mainFrame=new JFrame("Howmuch");

	
	/*JField는 텍스트를 입력 할 수 있는 텍스트 박스 클래스
	 * JLable은 텍스트클래스
	 * JButton은 버튼을 만드는 클래스
	*/
	
	//main
	JTextField IDtxtfield=new JTextField();
	JTextField PWtxtfield=new JTextField();
	JLabel loginLabel = new JLabel("ID ");
	JLabel PWLabel = new JLabel("Password ");
	JButton Login = new JButton(new ImageIcon("./image/loginbtn.png"));
	JButton Join= new JButton(new ImageIcon("./image/joinbtn.png"));

	//second
	JButton Plus = new JButton(new ImageIcon("./image/addbtn.png"));
	JButton Minus= new JButton(new ImageIcon("./image/delbtn.png"));
	JTextField Date=new JTextField();
	JTextField method_of_payment=new JTextField();
	JTextField category=new JTextField();
	JTextField Purchase_history=new JTextField();
	JTextField Price=new JTextField(3);

	//join
	JLabel join_name=new JLabel("이름");
	JLabel join_ID=new JLabel("아이디");
	JLabel join_PW=new JLabel("비밀번호");
	JLabel join_PWC=new JLabel("비밀번호 확인");
	JLabel join_email=new JLabel("이메일");
	JTextField join_namefield=new JTextField();
	JTextField join_IDfield=new JTextField();
	JTextField join_PWfield=new JTextField();
	JTextField join_PWCfield=new JTextField();
	JTextField join_emailfield=new JTextField();
	JButton new_join = new JButton("Join");
	JButton cancel = new JButton("Cancel");
	JButton input=new JButton("input");
	JButton view=new JButton("view");
	JButton statistics=new JButton("statistics");


	public How_much2() {
		mainFrame();
	}

	//메인화면
	public void mainFrame() {

		//크기와 위치를 정하는 메서드(x좌표, y좌표, 가로길이, 세로길이)
		loginLabel.setBounds(250, 430,100,30); 
		//폰트명, 굵기, 폰트크기
		loginLabel.setFont(new Font("Arial Black", Font.BOLD, 15)); 

		PWLabel.setBounds(250, 480, 100, 30);
		PWLabel.setFont(new Font("Arial Black", Font.BOLD, 13));

		IDtxtfield.setFont(new Font("굴림", Font.BOLD, 15));
		IDtxtfield.setBounds(330, 430,178,25);

		PWtxtfield.setFont(new Font("굴림", Font.BOLD, 15));
		PWtxtfield.setBounds(330,480, 178, 25);

		Login.setBounds(330,520,75,32);
		Join.setBounds(430,520,75,32);

		
		mainFrame.add(loginLabel);
		mainFrame.add(PWLabel);
		mainFrame.add(IDtxtfield);
		mainFrame.add(PWtxtfield);
		mainFrame.add(Login);
		mainFrame.add(Join);

		ImagePanel sidePanel = new ImagePanel(new ImageIcon("./image/Main.png").getImage());
		mainFrame.add(sidePanel);
		mainFrame.pack();

		mainFrame.setLayout(null);
		//프레임 보이게 하기
		mainFrame.setVisible(true);
		mainFrame.setSize(840,640);
		//화면을 중앙에
		mainFrame.setLocationRelativeTo(null);
		//화면 종료
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//화면 사이즈,위치 고정
		mainFrame.setResizable(false);

		//Login버튼 누를 시 행동
		Login.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainFrame.setVisible(false);
				secondFrame();
			}


		});
		//join버튼 누를 시 행동
		Join.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainFrame.setVisible(false);
				joinFrame();
			}

		});

	}

	JFrame secondFrame=new JFrame("Howmuch");
	public void secondFrame() {
		Dimension dim = new Dimension(840,600);
		secondFrame.setLocation(200, 400);
		secondFrame.setPreferredSize(dim);

		//컴퓨터 날짜
		LocalDate now = LocalDate.now();
		int year = now.getYear();
		int month = now.getMonthValue();
		JLabel label = new JLabel(year + " " + month);
		label.setBounds(450, 0, 200, 150);
		label.setFont(new Font("굴림", Font.BOLD, 50));
		secondFrame.add(label);

		//카테고리 콤보
		String[] header= {"날짜","결제수단","카테고리","사용내역","가격"};
		String[][] contents= {{"","","","",""}};

		DefaultTableModel model = new DefaultTableModel(contents, header);
		JTable table=new JTable(model);
		JScrollPane scrollpane = new JScrollPane(table);

		//스크롤바
		scrollpane.setLocation(265,150);
		scrollpane.setSize(550,400);

		//테이블 내용
		Date.setFont(new Font("굴림", Font.BOLD, 15));
		Date.setBounds(330,430, 50, 25);

		method_of_payment.setFont(new Font("굴림", Font.BOLD, 15));
		method_of_payment.setBounds(330,480, 50, 25);

		category.setFont(new Font("굴림", Font.BOLD, 15));
		category.setBounds(330,530, 50, 25);

		Purchase_history.setFont(new Font("굴림", Font.BOLD, 15));
		Purchase_history.setBounds(330,580, 50, 25);

		Price.setFont(new Font("굴림", Font.BOLD, 15));
		Price.setBounds(330,630, 50, 25);

		//콤보박스 만들기
		TableColumn comm=table.getColumnModel().getColumn(2);
		JComboBox Category=new JComboBox();

		Category.addItem("교통비");
		Category.addItem("식비");
		Category.addItem("의류");
		Category.addItem("문화생활");
		Category.addItem("저축");
		Category.addItem("기타");
		comm.setCellEditor(new DefaultCellEditor(Category));

		//콤보박스 만들기
		TableColumn comm2=table.getColumnModel().getColumn(1);
		JComboBox Category2=new JComboBox();

		Category2.addItem("카드");
		Category2.addItem("현금");
		comm2.setCellEditor(new DefaultCellEditor(Category2));

		//버튼
		Plus.setBounds(650,120,70,20);
		Minus.setBounds(740,120,70,20);

		input.setBounds(20,100,200,40);
		view.setBounds(20,200,200,40);
		statistics.setBounds(20,300,200,40);

		Plus.addActionListener(new ActionListener() {

			//테이블
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String inputStr[] = new String[5];

				inputStr[0]=Date.getText();
				inputStr[1]=method_of_payment.getText();
				inputStr[2]=category.getText();
				inputStr[3]=Purchase_history.getText();
				inputStr[4]=Price.getText();

				model.addRow(inputStr);

				Date.setText("");
				method_of_payment.setText("");
				category.setText("");
				Purchase_history.setText("");
				Price.setText("");
			}
		});
		
		//del 버튼
		Minus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(table.getSelectedRow()==-1) {
					return;
				}else {
					model.removeRow(table.getSelectedRow());
				}
			}
		});

		secondFrame.add(scrollpane,BorderLayout.CENTER);
		secondFrame.add(Plus);
		secondFrame.add(Minus);
		secondFrame.add(input);
		secondFrame.add(view);
		secondFrame.add(statistics);

		ImagePanel sidePanel1 = new ImagePanel(new ImageIcon("./image/hehe.png").getImage());
		sidePanel1.setSize(840,640);
		secondFrame.add(sidePanel1);
		secondFrame.pack();

		secondFrame.setVisible(true);
		secondFrame.setLayout(null);
		//프레임 보이게 하기
		secondFrame.setSize(840,640);
		//화면을 중앙에
		secondFrame.setLocationRelativeTo(null);
		//화면 종료
		secondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//화면 사이즈 고정
		secondFrame.setResizable(false);

	}

	//회원가입창
	JFrame joinFrame=new JFrame("Join");
	public void joinFrame() {
		var label = new JLabel[5];
		var labelList = "이름,아이디,비밀번호,비밀번호확인,이메일".split(",");

		for(int i = 0; i < label.length; i++) {
			label[i] = new JLabel(labelList[i]);
			label[i].setFont(new Font("굴림", Font.BOLD, 18));
			label[i].setBounds(270, 200 + i * 50, 200, 30);
			joinFrame.add(label[i]);
		}

		var textField = new JTextField[5];

		for(int i = 0; i < textField.length; i++) {
			textField[i] = new JTextField();
			textField[i].setFont(new Font("Arial Black", Font.BOLD, 15));
			textField[i].setBounds(400, 200 + i * 50, 200, 30);
			joinFrame.add(textField[i]);
		}

		new_join.setBounds(330,480,90,30);
		cancel.setBounds(430,480,90,30);

		joinFrame.add(new_join);
		joinFrame.add(cancel);

		new_join.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent T) {
				// TODO Auto-generated method stub
				try {
					BufferedWriter bos=new BufferedWriter(new FileWriter("회원명단.txt",true));
					bos.write(join_namefield.getText()+"/");
					bos.write(join_IDfield.getText()+"/");
					bos.write(join_PWfield.getText()+"/");
					bos.write(join_PWCfield.getText()+"/");
					bos.write(join_emailfield.getText()+"\r\n");
					bos.close();
					JOptionPane.showMessageDialog(null, "회원가입을 축하합니다!");
					joinFrame.setVisible(false);
					new How_much2();


				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"회원가입에 실패하였습니다");
				}

			}

		});
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				joinFrame.setVisible(false);
				new How_much2();
			}

		});

		ImagePanel sidePanel = new ImagePanel(new ImageIcon("./image/join.png").getImage());
		joinFrame.add(sidePanel);
		joinFrame.pack();

		//프레임 보이게 하기
		joinFrame.setVisible(true);
		joinFrame.setSize(840,640);
		//화면을 중앙에
		joinFrame.setLocationRelativeTo(null);
		//화면 종료
		joinFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//화면 사이즈 고정
		joinFrame.setResizable(false);
	}

	public static void main(String[] args) {
		new How_much2();
	}
}
