package gestionDeParking; 

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Fenetre {

	private JFrame frame;
	
	ArrayList<Véhicule> véhicules;
	DefaultListModel<Véhicule> modéleListe;
	File fichier;
	FileWriter fw;
	PrintWriter pr;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Fenetre window = new Fenetre();
					window.frame.setVisible(true);
					window.frame.setTitle("La gestion d'un parking des véhicules");
					window.frame.setLocationRelativeTo(null);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Fenetre() {
		initialize();
		véhicules = new ArrayList<>();
		modéleListe = new DefaultListModel<Véhicule>();
		fichier = new File("fichier.veh");
		try {
			fw = new FileWriter(fichier);
			pr = new PrintWriter(fw);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 912, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JList listVéhicule = new JList();
		listVéhicule.setBackground(new Color(240, 248, 255));
		listVéhicule.setModel(new AbstractListModel() {
			
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		listVéhicule.setBounds(30, 10, 843, 307);
		frame.getContentPane().add(listVéhicule);
		
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBackground(new Color(0, 250, 154));
		btnAjouter.setForeground(new Color(0, 0, 0));
		btnAjouter.setFont(new Font("Calibri", Font.BOLD, 25));
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String marque,modéle,immatriculation,type;
				int vitesseMax,nombrePortes,choix;
				boolean remorque;
				Véhicule véhicule=null;
								
				type = JOptionPane.showInputDialog(frame,"Entrez le type du véhicule: voiture/camion/moto "
						,"Type du véhicule",JOptionPane.PLAIN_MESSAGE );
				
				if(type==null) { 
					
				}
				else if(type.equalsIgnoreCase("voiture")) {
				marque = JOptionPane.showInputDialog(frame,"Entrez la marque du voiture","Marque",
							JOptionPane.PLAIN_MESSAGE );
			    modéle = JOptionPane.showInputDialog(frame,"Entrez le modéle du voiture","Modéle",
							JOptionPane.PLAIN_MESSAGE);
			    immatriculation = JOptionPane.showInputDialog(frame,"Entrez l'immatriculation du voiture"
			    		,"Immatriculation",JOptionPane.PLAIN_MESSAGE);	
				nombrePortes = Integer.parseInt(JOptionPane.showInputDialog(frame,"Entrez le nombre de portes",
						"nombre de portes",JOptionPane.PLAIN_MESSAGE));
				
				véhicule = new Voiture(marque,modéle,immatriculation,nombrePortes); 
				
				
				}	
				
				else if(type.equalsIgnoreCase("moto")) {
				marque = JOptionPane.showInputDialog(frame,"Entrez la marque du moto","Marque",
							JOptionPane.PLAIN_MESSAGE );
				modéle = JOptionPane.showInputDialog(frame,"Entrez le modéle du moto","Modéle",
		  				    JOptionPane.PLAIN_MESSAGE);
				immatriculation = JOptionPane.showInputDialog(frame,"Entrez l'immatriculation du moto",
						"Immatriculation",JOptionPane.PLAIN_MESSAGE);		
				vitesseMax = Integer.parseInt(JOptionPane.showInputDialog(frame,"Entrez la vitesse du moto",
						"vitesse du moto",JOptionPane.PLAIN_MESSAGE));
				véhicule = new Moto(marque, modéle, immatriculation, vitesseMax);
				}	
				
				else if(type.equalsIgnoreCase("camion")) {
				marque = JOptionPane.showInputDialog(frame,"Entrez la marque du camion","Marque",
							JOptionPane.PLAIN_MESSAGE );
				modéle = JOptionPane.showInputDialog(frame,"Entrez le modéle du camion","Modéle",
							JOptionPane.PLAIN_MESSAGE);
				immatriculation = JOptionPane.showInputDialog(frame,"Entrez l'immatriculation du camion",
						"Immatriculation",JOptionPane.PLAIN_MESSAGE);	
				choix = JOptionPane.showConfirmDialog(frame,"Le camion a il un remorque?","remorque",
							JOptionPane.YES_NO_CANCEL_OPTION);
				  if(choix==0)remorque=true;
				  else remorque= false;
				  
				  véhicule = new Camion(marque, modéle, immatriculation, remorque);
				}
				
				else {
				   JOptionPane.showMessageDialog(frame,"text invalide");
				}
				
				véhicules.add(véhicule);
				modéleListe.add(modéleListe.getSize(),véhicule);
				listVéhicule.setModel(modéleListe);				
				
			}
			
		}); 
		btnAjouter.setBounds(10, 373, 138, 70);
		frame.getContentPane().add(btnAjouter);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listVéhicule.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(frame,"selectionnez la liste que vous voulez supprimer",
							"Pas de selection",JOptionPane.ERROR_MESSAGE);	
				}else {
					int indice = listVéhicule.getSelectedIndex();
					modéleListe.remove(indice);
					véhicules.remove(indice);
				}
			}
		});
		btnSupprimer.setBackground(Color.RED);
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSupprimer.setBounds(184, 375, 142, 70);
		frame.getContentPane().add(btnSupprimer);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBackground(new Color(60, 179, 113));
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String marque,modéle,immatriculation;
				int portesVoiture,vitesseMaximal,remorque;
				
				if(listVéhicule.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(frame,"selectionnez la liste que vous voulez modifier",
							"Pas de selection",JOptionPane.ERROR_MESSAGE);	
				}else {
					int indice = listVéhicule.getSelectedIndex();
					
					Véhicule v = véhicules.get(indice);
					
					marque = JOptionPane.showInputDialog(frame, "Modifier la marque",v.getMarque());
					v.setMarque(marque);
					
					modéle = JOptionPane.showInputDialog(frame, "Modifier le modéle",v.getModéle());
					v.setModéle(modéle);
					
					immatriculation = JOptionPane.showInputDialog(frame, "Modifier l'immatriculation",
							v.getImmatriculation());
					v.setImmatriculation(immatriculation);
					
					if(v instanceof Voiture) {
						portesVoiture = Integer.parseInt(JOptionPane.showInputDialog(frame, 
								"Modifier le nombres de protes",((Voiture)v).getNombrePortes()));
						((Voiture) v).setNombrePortes(portesVoiture);
					
					}else if (v instanceof Moto){
						vitesseMaximal = Integer.parseInt(JOptionPane.showInputDialog(frame, 
								"Modifier la vitesse maximal",((Voiture)v).getNombrePortes()));
						((Moto) v).setVitesseMax(vitesseMaximal);
							
					}else if(v instanceof Camion ) {
						remorque = JOptionPane.showConfirmDialog(frame,"Modifier l'existence du remorque",
								"Modification",JOptionPane.YES_NO_CANCEL_OPTION);
						boolean choix=true;
						if(remorque== JOptionPane.NO_OPTION) choix=false;
						((Camion) v).setRemorque(choix);
							
					}else {
						JOptionPane.showMessageDialog(frame, "erreur","erreur",JOptionPane.ERROR_MESSAGE);
					}	
					listVéhicule.setModel(modéleListe);
				}
			}
		});
		btnModifier.setFont(new Font("Calibri", Font.BOLD, 25));
		btnModifier.setBounds(372, 373, 125, 70);
		frame.getContentPane().add(btnModifier);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setBackground(new Color(222, 184, 135));
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Véhicule v :véhicules) {
					pr.println(v);
				}	
				pr.close();
				
			}
		});
		btnEnregistrer.setFont(new Font("Calibri", Font.BOLD, 25));
		btnEnregistrer.setBounds(534, 377, 155, 70);
		frame.getContentPane().add(btnEnregistrer);
		
		JButton btnFermer = new JButton("Fermer");
		btnFermer.setBackground(new Color(255, 165, 0));
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 int choix = JOptionPane.showConfirmDialog(frame,"etes vous sur de vouloir sortir?","Confirmation",
					 JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);	
				
			 if(choix==0) System.exit(0);
			}
		});
		btnFermer.setFont(new Font("Calibri", Font.BOLD, 25));
		btnFermer.setBounds(731, 373, 125, 70);
		frame.getContentPane().add(btnFermer);

		
	}
}
