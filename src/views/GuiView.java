package views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import interfaces.AddButtonListener;
import interfaces.ArchiveButtonListener;

@SuppressWarnings("serial")
public class GuiView extends JFrame {
	private AddButtonListener addButtonListener;
	private ArchiveButtonListener archiveButtonListener;
	
	private JComboBox _comboCat = new JComboBox();
	private JComboBox _comboType = new JComboBox();
	
	private JTextField _brandTF = new JTextField();
	private JTextField _modelTF = new JTextField();
	private JTextField _yearTF = new JTextField();
	
	private JButton _add = new JButton("Ajouter");
	private JButton _archiv = new JButton("Archiver");
	
	private ButtonGroup _bg = new ButtonGroup();
	private JRadioButton _auto = new JRadioButton("Auto");
	private JRadioButton _manual = new JRadioButton("Manuel");
	
	public GuiView() {
		initComboCat();
		initComboType();
		
		_bg.add(_auto);
		_bg.add(_manual);
		
		this.setTitle("Car Manager");
		this.setSize(350, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.setLayout(new GridLayout(6, 2));
		
		this.getContentPane().add(new JLabel(" Catégories :"));
		this.getContentPane().add(_comboCat);
		
		this.getContentPane().add(new JLabel(" Marque :"));
		this.getContentPane().add(_brandTF);
		
		this.getContentPane().add(new JLabel(" Modèle :"));
		this.getContentPane().add(_modelTF);
		
		this.getContentPane().add(new JLabel(" Année :"));
		this.getContentPane().add(_yearTF);
		

		this.getContentPane().add(new JLabel(" Type :"));
		this.getContentPane().add(_comboType);
		
		this.getContentPane().add(_add);
		
		this.getContentPane().add(_archiv);
		
		_add.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				addButtonListener.onAddClick();
			}
		});
		
		_archiv.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				archiveButtonListener.onArchiveClick();				
			}
		});
	}
	
	public void initComboCat() {
		_comboCat.addItem("Citadine");
		_comboCat.addItem("Berline");
		_comboCat.addItem("Break");
		_comboCat.addItem("Sportive");
		_comboCat.addItem("Compact");
	}
	
	public void initComboType() {
		_comboType.addItem("Auto");
		_comboType.addItem("Manuelle");
	}

	public JComboBox get_comboCat() {
		return _comboCat;
	}

	public void set_comboCat(JComboBox _comboCat) {
		this._comboCat = _comboCat;
	}

	public AddButtonListener getAddButtonListener() {
		return addButtonListener;
	}

	public void setAddButtonListener(AddButtonListener addButtonListener) {
		this.addButtonListener = addButtonListener;
	}

	public ArchiveButtonListener getArchiveButtonListener() {
		return archiveButtonListener;
	}

	public void setArchiveButtonListener(ArchiveButtonListener archiveButtonListener) {
		this.archiveButtonListener = archiveButtonListener;
	}
	
	public String getCategory() {
		return _comboCat.getSelectedItem().toString();
	}
	
	public String getTransmission() {
		return _comboType.getSelectedItem().toString();
	}
	
	public String getBrand() {
		return _brandTF.getText();
	}
	
	public String getModel() {
		return _modelTF.getText();
	}	
	
	public int getYear() {
		return Integer.parseInt(_yearTF.getText());
	}
}
