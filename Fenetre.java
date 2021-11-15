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
	
	ArrayList<V�hicule> v�hicules;
	DefaultListModel<V�hicule> mod�leListe;
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
					window.frame.setTitle("La gestion d'un parking des v�hicules");
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
		v�hicules = new ArrayList<>();
		mod�leListe = new DefaultListModel<V�hicule>();
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
		
		JList listV�hicule = new JList();
		listV�hicule.setBackground(new Color(240, 248, 255));
		listV�hicule.setModel(new AbstractListModel() {
			
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		listV�hicule.setBounds(30, 10, 843, 307);
		frame.getContentPane().add(listV�hicule);
		
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBackground(new Color(0, 250, 154));
		btnAjouter.setForeground(new Color(0, 0, 0));
		btnAjouter.setFont(new Font("Calibri", Font.BOLD, 25));
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String marque,mod�le,immatriculation,type;
				int vitesseMax,nombrePortes,choix;
				boolean remorque;
				V�hicule v�hicule=null;
								
				type = JOptionPane.showInputDialog(frame,"Entrez le type du v�hicule: voiture/camion/moto "
						,"Type du v�hicule",JOptionPane.PLAIN_MESSAGE );
				
				if(type==null) { 
					
				}
				else if(type.equalsIgnoreCase("voiture")) {
				marque = JOptionPane.showInputDialog(frame,"Entrez la marque du voiture","Marque",
							JOptionPane.PLAIN_MESSAGE );
			    mod�le = JOptionPane.showInputDialog(frame,"Entrez le mod�le du voiture","Mod�le",
							JOptionPane.PLAIN_MESSAGE);
			    immatriculation = JOptionPane.showInputDialog(frame,"Entrez l'immatriculation du voiture"
			    		,"Immatriculation",JOptionPane.PLAIN_MESSAGE);	
				nombrePortes = Integer.parseInt(JOptionPane.showInputDialog(frame,"Entrez le nombre de portes",
						"nombre de portes",JOptionPane.PLAIN_MESSAGE));
				
				v�hicule = new Voiture(marque,mod�le,immatriculation,nombrePortes); 
				
				
				}	
				
				else if(type.equalsIgnoreCase("moto")) {
				marque = JOptionPane.showInputDialog(frame,"Entrez la marque du moto","Marque",
							JOptionPane.PLAIN_MESSAGE );
				mod�le = JOptionPane.showInputDialog(frame,"Entrez le mod�le du moto","Mod�le",
		  				    JOptionPane.PLAIN_MESSAGE);
				immatriculation = JOptionPane.showInputDialog(frame,"Entrez l'immatriculation du moto",
						"Immatriculation",JOptionPane.PLAIN_MESSAGE);		
				vitesseMax = Integer.parseInt(JOptionPane.showInputDialog(frame,"Entrez la vitesse du moto",
						"vitesse du moto",JOptionPane.PLAIN_MESSAGE));
				v�hicule = new Moto(marque, mod�le, immatriculation, vitesseMax);
				}	
				
				else if(type.equalsIgnoreCase("camion")) {
				marque = JOptionPane.showInputDialog(frame,"Entrez la marque du camion","Marque",
							JOptionPane.PLAIN_MESSAGE );
				mod�le = JOptionPane.showInputDialog(frame,"Entrez le mod�le du camion","Mod�le",
							JOptionPane.PLAIN_MESSAGE);
				immatriculation = JOptionPane.showInputDialog(frame,"Entrez l'immatriculation du camion",
						"Immatriculation",JOptionPane.PLAIN_MESSAGE);	
				choix = JOptionPane.showConfirmDialog(frame,"Le camion a il un remorque?","remorque",
							JOptionPane.YES_NO_CANCEL_OPTION);
				  if(choix==0)remorque=true;
				  else remorque= false;
				  
				  v�hicule = new Camion(marque, mod�le, immatriculation, remorque);
				}
				
				else {
				   JOptionPane.showMessageDialog(frame,"text invalide");
				}
				
				v�hicules.add(v�hicule);
				mod�leListe.add(mod�leListe.getSize(),v�hicule);
				listV�hicule.setModel(mod�leListe);				
				
			}
			
		}); 
		btnAjouter.setBounds(10, 373, 138, 70);
		frame.getContentPane().add(btnAjouter);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listV�hicule.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(frame,"selectionnez la liste que vous voulez supprimer",
							"Pas de selection",JOptionPane.ERROR_MESSAGE);	
				}else {
					int indice = listV�hicule.getSelectedIndex();
					mod�leListe.remove(indice);
					v�hicules.remove(indice);
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
				String marque,mod�le,immatriculation;
				int portesVoiture,vitesseMaximal,remorque;
				
				if(listV�hicule.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(frame,"selectionnez la liste que vous voulez modifier",
							"Pas de selection",JOptionPane.ERROR_MESSAGE);	
				}else {
					int indice = listV�hicule.getSelectedIndex();
					
					V�hicule v = v�hicules.get(indice);
					
					marque = JOptionPane.showInputDialog(frame, "Modifier la marque",v.getMarque());
					v.setMarque(marque);
					
					mod�le = JOptionPane.showInputDialog(frame, "Modifier le mod�le",v.getMod�le());
					v.setMod�le(mod�le);
					
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
					listV�hicule.setModel(mod�leListe);
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
				for(V�hicule v :v�hicules) {
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
