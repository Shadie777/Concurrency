package concurrency;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ConcurrencyView {

	private JFrame frame;
	private JTextField fileTextfield1;
	private JTextField time_Taken;
	private JButton btnNoConcurrency;
	private JTextField stringTextfield;
	private JTextField fileTextfield2;
	private JTextField fileTextfield3;
	private JLabel lblFile_1;
	private JLabel lblFile_2;
	private JLabel lblString;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConcurrencyView window = new ConcurrencyView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConcurrencyView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 609, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		fileTextfield1 = new JTextField();
		fileTextfield1.setBounds(77, 23, 228, 27);
		frame.getContentPane().add(fileTextfield1);
		fileTextfield1.setColumns(10);

		JButton btnChooseFile = new JButton("Choose File");
		btnChooseFile.setBounds(315, 24, 151, 25);
		frame.getContentPane().add(btnChooseFile);

		btnNoConcurrency = new JButton("No Concurrency");
		btnNoConcurrency.setBounds(77, 192, 127, 25);
		frame.getContentPane().add(btnNoConcurrency);

		JButton btnThreads = new JButton("Threads");
		btnThreads.setBounds(214, 192, 115, 25);
		frame.getContentPane().add(btnThreads);

		JButton btnParallel = new JButton("Parallel Streams");
		btnParallel.setBounds(339, 192, 127, 25);
		frame.getContentPane().add(btnParallel);

		time_Taken = new JTextField();
		time_Taken.setBounds(175, 228, 291, 22);
		frame.getContentPane().add(time_Taken);
		time_Taken.setColumns(10);

		JLabel lblTimeTaken = new JLabel("Time Taken");
		lblTimeTaken.setBounds(77, 218, 89, 43);
		frame.getContentPane().add(lblTimeTaken);

		stringTextfield = new JTextField();
		stringTextfield.setBounds(76, 145, 393, 22);
		frame.getContentPane().add(stringTextfield);
		stringTextfield.setColumns(10);

		fileTextfield2 = new JTextField();
		fileTextfield2.setColumns(10);
		fileTextfield2.setBounds(77, 61, 228, 27);
		frame.getContentPane().add(fileTextfield2);

		fileTextfield3 = new JTextField();
		fileTextfield3.setColumns(10);
		fileTextfield3.setBounds(77, 107, 228, 27);
		frame.getContentPane().add(fileTextfield3);

		JButton BtnChooseFile2 = new JButton("Choose File");
		BtnChooseFile2.setBounds(315, 61, 151, 27);
		frame.getContentPane().add(BtnChooseFile2);

		JButton btnChooseFile3 = new JButton("Choose File");
		btnChooseFile3.setBounds(315, 107, 151, 27);
		frame.getContentPane().add(btnChooseFile3);

		JLabel lblFile = new JLabel("File 1:");
		lblFile.setBounds(21, 20, 65, 33);
		frame.getContentPane().add(lblFile);

		lblFile_1 = new JLabel("File 2:");
		lblFile_1.setBounds(21, 61, 65, 33);
		frame.getContentPane().add(lblFile_1);

		lblFile_2 = new JLabel("File 3:");
		lblFile_2.setBounds(21, 104, 65, 33);
		frame.getContentPane().add(lblFile_2);

		lblString = new JLabel("String:");
		lblString.setBounds(21, 143, 45, 27);
		frame.getContentPane().add(lblString);

		btnChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseFile();
			}
		});

		BtnChooseFile2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseFile();
			}
		});

		btnChooseFile3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseFile();
			}
		});
		btnNoConcurrency.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					long start = System.nanoTime();
					NoConcurrencySearch.main(fileTextfield1.getText(),
							stringTextfield.getText());
					NoConcurrencySearch.main(fileTextfield2.getText(),
							stringTextfield.getText());
					NoConcurrencySearch.main(fileTextfield3.getText(),
							stringTextfield.getText());
					long stop = System.nanoTime();
					double time = (double) (stop - start) / 1_000_000_000;
					System.out.println("It took : " + time);
					time_Taken.setText(Double.toString(time));
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnThreads.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String[] strArray = new String[] {
							fileTextfield1.getText(), fileTextfield2.getText(),
							fileTextfield3.getText() };

					long start = System.nanoTime();
					ThreadsReadFile.main(strArray, stringTextfield.getText());
					long stop = System.nanoTime();
					double time = (double) (stop - start) / 1_000_000_000;
					System.out.println("It took : " + time);

					time_Taken.setText(Double.toString(time));
				} catch (IOException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		btnParallel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long start = System.nanoTime();
				ParallelStreams.main(fileTextfield1.getText(),
						stringTextfield.getText());
				ParallelStreams.main(fileTextfield2.getText(),
						stringTextfield.getText());
				ParallelStreams.main(fileTextfield3.getText(),
						stringTextfield.getText());
				long stop = System.nanoTime();

				double time = (double) (stop - start) / 1_000_000_000;
				System.out.println("It took : " + time);

				time_Taken.setText(Double.toString(time));
			}
		});
	}

	public void chooseFile() {
		JFileChooser fileChooser = new JFileChooser();

		fileChooser.setCurrentDirectory(new File(System
				.getProperty("user.home")));

		int result = fileChooser.showOpenDialog(frame);

		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			fileTextfield1.setText(selectedFile.getAbsolutePath());
		}
	}
}

