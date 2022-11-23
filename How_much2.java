package JavaProject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.AbstractButton;
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

class Client{
	String date;
	String ways;
	String category;
	String uselist;
	String price;

	public Client(String date, String ways, String category, String uselist,String price) {
		this.date=date;
		this.ways=ways;
		this.category=category;
		this.uselist=uselist;
		this.price=price;
	}
	public Client() {

	}
	public String getdate() {
		return date;
	}
	public void setId(String date) {
		this.date=date;
	}
	public String getways() {
		return ways;
	}
	public void setways(String ways) {
		this.ways=ways;
	}
	public String getcategory() {
		return category;
	}
	public void setcategory(String category) {
		this.category=category;
	}
	public String getuselist() {
		return uselist;
	}
	public void setuselist(String uselist) {
		this.uselist=uselist;
	}
	public String getprice() {
		return price;
	}
	public void setprice(String price) {
		this.price=price;
	}
}
public class How_much2 extends CommonFrame {
	protected static final AbstractButton IDtxttfield = null;

	JFrame mainFrame = new JFrame("Howmuch");

	/*
	 * JField는 텍스트를 입력 할 수 있는 텍스트 박스 클래스 JLable은 텍스트클래스 JButton은 버튼을 만드는 클래스
	 */

	// main
	JTextField IDtxtfield = new JTextField();
	JTextField PWtxtfield = new JTextField();
	JLabel loginLabel = new JLabel("ID ");
	JLabel PWLabel = new JLabel("Password ");
	JButton Login = new JButton(new ImageIcon("./image/loginbtn.png"));
	JButton Join = new JButton(new ImageIcon("./image/joinbtn.png"));

	// second
	JButton Plus = new JButton(new ImageIcon("./image/addbtn.png"));
	JButton Minus = new JButton(new ImageIcon("./image/delbtn.png"));
	JLabel date=new JLabel("날짜");
	JLabel way=new JLabel("결제수단");
	JLabel categorye=new JLabel("카테고리");
	JLabel uselist=new JLabel("사용내역");
	JLabel price=new JLabel("비용");
	JTextField Date = new JTextField();
	JTextField method_of_payment = new JTextField();
	JTextField category = new JTextField();
	JTextField Purchase_history = new JTextField();
	JTextField Price = new JTextField(3);

	// join
	JButton new_join = new JButton("Join");
	JButton cancel = new JButton("Cancel");
	JButton input = new JButton(new ImageIcon("./image/001.png"));
	//JButton view = new JButton();
	JButton statistics = new JButton(new ImageIcon("./image/002.png"));
	JTextField[] JointextField = new JTextField[5];
	JLabel[] Joinlabel = new JLabel[5];

	public How_much2() {
		mainFrame();
	}

	// 메인화면
	public void mainFrame() {

		// 크기와 위치를 정하는 메서드(x좌표, y좌표, 가로길이, 세로길이)
		loginLabel.setBounds(250, 430, 100, 30);
		// 폰트명, 굵기, 폰트크기
		loginLabel.setFont(new Font("Arial Black", Font.BOLD, 15));

		PWLabel.setBounds(250, 480, 100, 30);
		PWLabel.setFont(new Font("Arial Black", Font.BOLD, 13));

		IDtxtfield.setFont(new Font("굴림", Font.BOLD, 15));
		IDtxtfield.setBounds(330, 430, 178, 25);

		PWtxtfield.setFont(new Font("굴림", Font.BOLD, 15));
		PWtxtfield.setBounds(330, 480, 178, 25);

		Login.setBounds(330, 520, 75, 32);
		Join.setBounds(430, 520, 75, 32);

		mainFrame.add(loginLabel);
		mainFrame.add(PWLabel);
		mainFrame.add(IDtxtfield);
		mainFrame.add(PWtxtfield);
		mainFrame.add(Login);
		mainFrame.add(Join);


		// Login버튼 누를 시 행동
		Login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ID = IDtxtfield.getText();
				String PW = PWtxtfield.getText();

				String sql = "SELECT u_pw FROM shopingdb.user WHERE u_id = ?";

				try {
					var pstmt1 = con.prepareStatement(sql);
					pstmt1.setString(1, ID);

					var rs = pstmt1.executeQuery();

					if(rs.next()) {
						if(rs.getString(1).equals(PW)) {
							//로그인 성공
							JOptionPane.showMessageDialog(null,"로그인 성공!");
							mainFrame.setVisible(false);
							secondFrame();
						} else { //로그인 비밀번호 불일치
							JOptionPane.showMessageDialog(null,"비밀번호 불일치!");

						}
					} else {
						//아이디 없음
						JOptionPane.showMessageDialog(null,"아이디나 비밀번호를 다시 확인해주세요!");
					}
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		// join버튼 누를 시 행동
		Join.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainFrame.setVisible(false);
				joinFrame();
			}

		});
		ImagePanel sidePanel = new ImagePanel(new ImageIcon("./image/Main.png").getImage());
		mainFrame.add(sidePanel);
		mainFrame.pack();

		mainFrame.setLayout(null);
		// 프레임 보이게 하기
		mainFrame.setVisible(true);
		mainFrame.setSize(840, 640);
		// 화면을 중앙에
		mainFrame.setLocationRelativeTo(null);
		// 화면 종료
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 화면 사이즈,위치 고정
		mainFrame.setResizable(false);
	}

	protected static Object getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
	//--------------------------------------------------------------------------여기까지가 메인화면(로그인창)

	JFrame secondFrame = new JFrame("Howmuch");


	public void secondFrame() {

		Dimension dim = new Dimension(840, 600);
		secondFrame.setLocation(200, 400);
		secondFrame.setPreferredSize(dim);

		String[] comboBox1= new String[]{"교통비","식비","여가생활","저축","의류","기타"};
		JComboBox combo1=new JComboBox(comboBox1);

		String[] comboBox2= {"카드","현금"};
		JComboBox combo2=new JComboBox(comboBox2);

		date.setFont(new Font("굴림", Font.BOLD, 14));
		date.setBounds(280,130,50,50);
		way.setFont(new Font("굴림", Font.BOLD, 14));
		way.setBounds(480,130,80,50);
		categorye.setFont(new Font("굴림", Font.BOLD, 14));
		categorye.setBounds(280,170,80,50);
		uselist.setFont(new Font("굴림", Font.BOLD, 14));
		uselist.setBounds(480,170,80,50);
		price.setFont(new Font("굴림", Font.BOLD, 14));
		price.setBounds(680,170,50,50);

		Date.setFont(new Font("굴림", Font.BOLD, 15));
		Date.setBounds(350, 140, 120, 25);

		combo2.setFont(new Font("굴림", Font.BOLD, 15));
		combo2.setBounds(550, 140, 100, 25);

		combo1.setFont(new Font("굴림", Font.BOLD, 15));
		combo1.setBounds(350, 180, 120, 25);

		Purchase_history.setFont(new Font("굴림", Font.BOLD, 15));
		Purchase_history.setBounds(550, 180, 120, 25);

		Price.setFont(new Font("굴림", Font.BOLD, 15));
		Price.setBounds(730, 180, 80, 25);

		secondFrame.add(date);
		secondFrame.add(way);
		secondFrame.add(categorye);
		secondFrame.add(uselist);
		secondFrame.add(price);

		secondFrame.add(Date);
		secondFrame.add(combo2);
		secondFrame.add(combo1);
		secondFrame.add(Purchase_history);
		secondFrame.add(Price);

		// 컴퓨터 날짜
		LocalDate now = LocalDate.now();
		int year = now.getYear();
		int month = now.getMonthValue();
		JLabel label = new JLabel(year + " " + month);
		label.setBounds(450, 0, 200, 150);
		label.setFont(new Font("굴림", Font.BOLD, 50));
		secondFrame.add(label);

		// 카테고리 콤보
		String[] header = { "날짜", "결제수단", "카테고리", "사용내역", "가격" };
		String[][] contents = { { "", "", "", "", "" } };

		DefaultTableModel model = new DefaultTableModel(contents, header);
		JTable table = new JTable(model);
		JScrollPane scrollpane = new JScrollPane(table);

		// 스크롤바
		scrollpane.setLocation(265, 250);
		scrollpane.setSize(550, 300);

		// 버튼
		Plus.setBounds(650, 220, 70, 20);
		Minus.setBounds(740, 220, 70, 20);

		input.setBounds(20, 100, 200, 40);
		statistics.setBounds(20, 300, 200, 40);

		Plus.addActionListener(new ActionListener() {

			// 테이블
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					updateSQL("INSERT INTO info(i_date,i_way,i_category,i_uselist,i_price) "
							+ "VALUES (?,?,?,?,?)",
							Date.getText(),
							combo2.getSelectedItem().toString(),
							combo1.getSelectedItem().toString(),
							Purchase_history.getText(),
							Price.getText());

					String Instr[]=new String[5];
					Instr[0]=Date.getText();
					Instr[1]=combo2.getSelectedItem().toString();
					Instr[2]=combo1.getSelectedItem().toString();
					Instr[3]=Purchase_history.getText();
					Instr[4]=Price.getText();
					model.addRow(Instr);



					System.out.println("info에 저장 성공");

				}catch(Exception ex) { 
					JOptionPane.showMessageDialog(null,"info에 실패하였습니다"); }
			}
		});

		// del 버튼
		Minus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (table.getSelectedRow() == -1) {
					return;
				} else {
					model.removeRow(table.getSelectedRow());
				}
			}
		});

		statistics.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				secondFrame.setVisible(false);
				staticFrame();
			}

		});

		// });



		secondFrame.add(scrollpane, BorderLayout.CENTER);
		secondFrame.add(Plus);
		secondFrame.add(Minus);
		secondFrame.add(input);
		//secondFrame.add(view);
		secondFrame.add(statistics);

		ImagePanel sidePanel1 = new ImagePanel(new ImageIcon("./image/hehe.png").getImage());
		sidePanel1.setSize(840, 640);
		secondFrame.add(sidePanel1);
		secondFrame.pack();

		secondFrame.setVisible(true);
		secondFrame.setLayout(null);
		// 프레임 보이게 하기
		secondFrame.setSize(840, 640);
		// 화면을 중앙에
		secondFrame.setLocationRelativeTo(null);
		// 화면 종료
		secondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 화면 사이즈 고정
		secondFrame.setResizable(false);

	}
	//--------------------------------------------------------------------------------여기까지가 가게부 입력창
	JFrame joinFrame = new JFrame("Join");

	public void joinFrame() {


		var labelList = "이름,아이디,비밀번호,비밀번호확인,이메일".split(",");

		for (int i = 0; i < Joinlabel.length; i++) {
			Joinlabel[i] = new JLabel(labelList[i]);
			Joinlabel[i].setFont(new Font("굴림", Font.BOLD, 18));
			Joinlabel[i].setBounds(270, 200 + i * 50, 200, 30);
			joinFrame.add(Joinlabel[i]);
		}



		for (int i = 0; i < JointextField.length; i++) {
			JointextField[i] = new JTextField();
			JointextField[i].setFont(new Font("Arial Black", Font.BOLD, 15));
			JointextField[i].setBounds(400, 200 + i * 50, 200, 30);
			joinFrame.add(JointextField[i]);
		}

		new_join.setBounds(330, 480, 90, 30);
		cancel.setBounds(430, 480, 90, 30);

		joinFrame.add(new_join);
		joinFrame.add(cancel);

		new_join.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent T) {
				// TODO Auto-generated method stub

				try {
					updateSQL("INSERT INTO user(u_name,u_id,u_pw,u_pwCheck,u_email) "
							+ "VALUES (?,?,?,?,?)",
							JointextField[0].getText(),
							JointextField[1].getText(),
							JointextField[2].getText(),
							JointextField[3].getText(),
							JointextField[4].getText());

					JOptionPane.showMessageDialog(null, "회원가입을 축하합니다!");

				}catch(Exception ex) { 
					JOptionPane.showMessageDialog(null,"회원가입에 실패하였습니다"); }				


				joinFrame.setVisible(false);
				new How_much2();

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

		// 프레임 보이게 하기
		joinFrame.setVisible(true);
		joinFrame.setSize(840, 640);
		// 화면을 중앙에
		joinFrame.setLocationRelativeTo(null);
		// 화면 종료
		joinFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 화면 사이즈 고정
		joinFrame.setResizable(false);
	}
	//----------------------------------------------------------------------------------여기까지가 회원가입창
	// 통계화면
	JFrame staticFrame = new JFrame("static");

	public void staticFrame() {
		ImagePanel sidePanel = new ImagePanel(new ImageIcon("./image/join.png").getImage());
		staticFrame.add(sidePanel);
		staticFrame.pack();

		// 프레임 보이게 하기
		staticFrame.setVisible(true);
		staticFrame.setSize(840, 640);
		// 화면을 중앙에
		staticFrame.setLocationRelativeTo(null);
		// 화면 종료
		staticFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 화면 사이즈 고정
		staticFrame.setResizable(false);
	}

	public static void main(String[] args) {
		new How_much2();
	}
}