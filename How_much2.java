package JavaProject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class How_much2 {
	JFrame mainFrame=new JFrame("Howmuch");
	
	//main
	JTextField IDtxtfield=new JTextField();
	JTextField PWtxtfield=new JTextField();
	JLabel loginLabel = new JLabel("ID ");
	JLabel PWLabel = new JLabel("Password ");
	JButton Login = new JButton("Login");
	JButton Join= new JButton("Join");
	
	//second
	JButton Plus = new JButton("추가");
	JButton Minus= new JButton("삭제");
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
	
	public How_much2() {
		mainFrame();
	}
	
	//메인화면
	public void mainFrame() {

		
		loginLabel.setBounds(250, 360,100,100); //x좌표, y좌표, 가로길이, 세로길이
		loginLabel.setFont(new Font("굴림", Font.BOLD, 15)); //폰트명, 굵기, 폰트크기
		
		PWLabel.setBounds(250, 430, 274, 40);
		PWLabel.setFont(new Font("굴림", Font.BOLD, 15));
		
		IDtxtfield.setFont(new Font("굴림", Font.BOLD, 15));
		IDtxtfield.setBounds(330, 400,178,25);
		
		PWtxtfield.setFont(new Font("굴림", Font.BOLD, 15));
		PWtxtfield.setBounds(330,430, 178, 25);
		
		
		Login.setBounds(330,480,70,28);
		Join.setBounds(430,480,70,28);
		
		mainFrame.add(loginLabel);
		mainFrame.add(PWLabel);
		mainFrame.add(IDtxtfield);
		mainFrame.add(PWtxtfield);
		mainFrame.add(Login);
		mainFrame.add(Join);
		
		ImagePanel sidePanel = new ImagePanel(new ImageIcon("./image/Main.jpg").getImage());
		mainFrame.add(sidePanel);
		mainFrame.pack();
		
		mainFrame.setLayout(null);
		//프레임 보이게 하기
		mainFrame.setVisible(true);
		mainFrame.setSize(840,600);
		//화면을 중앙에
		mainFrame.setLocationRelativeTo(null);
		//화면 종료
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//화면 사이즈 고정
		mainFrame.setResizable(false);
		
		
		//Login버튼 누를 시 이동
		Login.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainFrame.setVisible(false);
				secondFrame();
			}

			
		});
		//join버튼 누를 시 이동
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
		
		Dimension dim=new Dimension(840,600);
		secondFrame.setLocation(200, 400);
		secondFrame.setPreferredSize(dim);
		
		String[] header= {"날짜","결제수단","카테고리","사용내역","가격"};
		String[][] contents= {{"","","","",""}};
		
		DefaultTableModel model = new DefaultTableModel(contents, header);
		JTable table=new JTable(model);
		JScrollPane scrollpane = new JScrollPane(table);
		
		scrollpane.setLocation(0,150);
		scrollpane.setSize(840,600);
		
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
		
		Plus.setBounds(600,100,90,30);
		Minus.setBounds(700,100,90,30);
		
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
		
		
		ImagePanel sidePanel1 = new ImagePanel(new ImageIcon("./image/Background.png").getImage());
		secondFrame.add(sidePanel1);
		secondFrame.pack();
		
		secondFrame.setVisible(true);
		secondFrame.setLayout(null);
		//프레임 보이게 하기
		secondFrame.setSize(840,600);
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
		//Label
				join_name.setBounds(250, 150,100,30); //x좌표, y좌표, 가로길이, 세로길이
				join_name.setFont(new Font("굴림", Font.BOLD, 17)); //폰트명, 굵기, 폰트크기
				
				join_ID.setBounds(250, 200,100,30); 
				join_ID.setFont(new Font("굴림", Font.BOLD, 17));
				
				join_PW.setBounds(250, 250,100,30); 
				join_PW.setFont(new Font("굴림", Font.BOLD, 17));
				
				join_PWC.setBounds(250, 300,130,30); 
				join_PWC.setFont(new Font("굴림", Font.BOLD, 17));
				
				join_email.setBounds(250, 350,100,30); 
				join_email.setFont(new Font("굴림", Font.BOLD, 17));
				
				//텍스트 필드
				join_namefield.setFont(new Font("굴림", Font.BOLD, 15));
				join_namefield.setBounds(370, 150,200,30); 
				

				join_IDfield.setFont(new Font("굴림", Font.BOLD, 15));
				join_IDfield.setBounds(370, 200,200,30); 
				
				join_PWfield.setFont(new Font("굴림", Font.BOLD, 15));
				join_PWfield.setBounds(370, 250,200,30); 
				
				join_PWCfield.setFont(new Font("굴림", Font.BOLD, 15));
				join_PWCfield.setBounds(370, 300,200,30); 
				
				join_emailfield.setFont(new Font("굴림", Font.BOLD, 15));
				join_emailfield.setBounds(370, 350,200,30); 
				
				
				
				new_join.setBounds(330,430,90,30);
				cancel.setBounds(430,430,90,30);
			
				joinFrame.add(join_name);
				joinFrame.add(join_ID);
				joinFrame.add(join_PW);
				joinFrame.add(join_PWC);
				joinFrame.add(join_email);
				joinFrame.add(join_namefield);
				joinFrame.add(join_IDfield);
				joinFrame.add(join_PWfield);
				joinFrame.add(join_PWCfield);
				joinFrame.add(join_emailfield);
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
							mainFrame();
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
						mainFrame();
					}
					
				});
				
		ImagePanel sidePanel = new ImagePanel(new ImageIcon("./image/join.png").getImage());
		joinFrame.add(sidePanel);
		joinFrame.pack();
		
		joinFrame.setLayout(null);
		//프레임 보이게 하기
		joinFrame.setVisible(true);
		joinFrame.setSize(840,600);
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
