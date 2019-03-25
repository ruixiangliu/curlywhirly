// Copyright 2009-2019 Information & Computational Sciences, JHI. All rights
// reserved. Use is subject to the accompanying licence terms.

package jhi.curlywhirly.gui;

import jhi.curlywhirly.util.*;
import scri.commons.gui.*;
import scri.commons.gui.matisse.*;

import java.awt.event.*;

public class StartPanelHelpNB extends javax.swing.JPanel implements ActionListener
{
	private HyperLinkLabel[] labels = new HyperLinkLabel[10];
	private String[] urls = new String[10];

	private static String home =
		"http://curlywhirly.hutton.ac.uk/en/latest/";

	public StartPanelHelpNB()
	{
		initComponents();
		setOpaque(false);

		RB.setText(homeLabel, "gui.NBStartHelpPanel.homeLabel");

		homeLabel.setIcon(Icons.getIcon("BOOK"));
		homeLabel.addActionListener(this);

		urls[0] = "http://curlywhirly.hutton.ac.uk/en/latest/data_format.html";
		urls[1] = "http://curlywhirly.hutton.ac.uk/en/latest/importing_data.html";
		urls[2] = "http://curlywhirly.hutton.ac.uk/en/latest/category_selection.html";
		urls[3] = "http://curlywhirly.hutton.ac.uk/en/latest/data_tab.html";
		urls[4] = "http://curlywhirly.hutton.ac.uk/en/latest/controls_tab.html";
		urls[5] = "http://curlywhirly.hutton.ac.uk/en/latest/3d_interaction.html";
		urls[6] = "http://curlywhirly.hutton.ac.uk/en/latest/capture_screenshot.html";
		urls[7] = "http://curlywhirly.hutton.ac.uk/en/latest/capture_movie.html";
		urls[8] = "http://curlywhirly.hutton.ac.uk/en/latest/curlywhirly_options.html";
		urls[9] = "https://ics.hutton.ac.uk/curlywhirly/download-curlywhirly/curlywhirly-release-notes/";

		labels[0] = link1;
		labels[1] = link2;
		labels[2] = link3;
		labels[3] = link4;
		labels[4] = link5;
		labels[5] = link6;
		labels[6] = link7;
		labels[7] = link8;
		labels[8] = link9;
		labels[9] = link10;

		for (int i = 0; i < labels.length; i++)
		{
			RB.setText(labels[i], "gui.NBStartHelpPanel.link" + (i + 1));
			labels[i].addActionListener(this);
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == homeLabel)
			NetworkUtils.visitURL(home);

		else
		{
			for (int i = 0; i < labels.length; i++)
				if (e.getSource() == labels[i])
					NetworkUtils.visitURL(urls[i]);
		}
	}

	/**
	 * This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents()
	{

		homeLabel = new scri.commons.gui.matisse.HyperLinkLabel();
		link1 = new scri.commons.gui.matisse.HyperLinkLabel();
		link2 = new scri.commons.gui.matisse.HyperLinkLabel();
		link3 = new scri.commons.gui.matisse.HyperLinkLabel();
		link4 = new scri.commons.gui.matisse.HyperLinkLabel();
		link5 = new scri.commons.gui.matisse.HyperLinkLabel();
		link6 = new scri.commons.gui.matisse.HyperLinkLabel();
		link7 = new scri.commons.gui.matisse.HyperLinkLabel();
		link8 = new scri.commons.gui.matisse.HyperLinkLabel();
		spacerLabel = new javax.swing.JLabel();
		link9 = new scri.commons.gui.matisse.HyperLinkLabel();
		link10 = new scri.commons.gui.matisse.HyperLinkLabel();
		jLabel1 = new javax.swing.JLabel();

		homeLabel.setForeground(new java.awt.Color(68, 106, 156));
		homeLabel.setText("Visit the online CurlyWhirly user manual");

		link1.setForeground(new java.awt.Color(68, 106, 156));
		link1.setIcon(Icons.getIcon("BUTTON"));
		link1.setText("link1");

		link2.setForeground(new java.awt.Color(68, 106, 156));
		link2.setIcon(Icons.getIcon("BUTTON"));
		link2.setText("link2");

		link3.setForeground(new java.awt.Color(68, 106, 156));
		link3.setIcon(Icons.getIcon("BUTTON"));
		link3.setText("link3");

		link4.setForeground(new java.awt.Color(68, 106, 156));
		link4.setIcon(Icons.getIcon("BUTTON"));
		link4.setText("link4");

		link5.setForeground(new java.awt.Color(68, 106, 156));
		link5.setIcon(Icons.getIcon("BUTTON"));
		link5.setText("link5");

		link6.setForeground(new java.awt.Color(68, 106, 156));
		link6.setIcon(Icons.getIcon("BUTTON"));
		link6.setText("link6");

		link7.setForeground(new java.awt.Color(68, 106, 156));
		link7.setIcon(Icons.getIcon("BUTTON"));
		link7.setText("link7");

		link8.setForeground(new java.awt.Color(68, 106, 156));
		link8.setIcon(Icons.getIcon("BUTTON"));
		link8.setText("link8");

		spacerLabel.setText(" ");

		link9.setForeground(new java.awt.Color(68, 106, 156));
		link9.setIcon(Icons.getIcon("BUTTON"));
		link9.setText("link9");

		link10.setForeground(new java.awt.Color(68, 106, 156));
		link10.setIcon(Icons.getIcon("BUTTON"));
		link10.setText("link10");

		jLabel1.setText("Suggested topics:");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(homeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(link1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(link2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(link3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(link4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(link5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(link6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(link7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(link8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup()
							.addComponent(link9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(spacerLabel))
						.addComponent(link10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel1))
					.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(homeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(18, 18, 18)
					.addComponent(jLabel1)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(link1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(link2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(6, 6, 6)
					.addComponent(link3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(6, 6, 6)
					.addComponent(link4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(6, 6, 6)
					.addComponent(link5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(6, 6, 6)
					.addComponent(link6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(link7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(link8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(spacerLabel)
						.addComponent(link9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(link10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
	}// </editor-fold>//GEN-END:initComponents


	// Variables declaration - do not modify//GEN-BEGIN:variables
	private scri.commons.gui.matisse.HyperLinkLabel homeLabel;
	private javax.swing.JLabel jLabel1;
	private scri.commons.gui.matisse.HyperLinkLabel link1;
	private scri.commons.gui.matisse.HyperLinkLabel link10;
	private scri.commons.gui.matisse.HyperLinkLabel link2;
	private scri.commons.gui.matisse.HyperLinkLabel link3;
	private scri.commons.gui.matisse.HyperLinkLabel link4;
	private scri.commons.gui.matisse.HyperLinkLabel link5;
	private scri.commons.gui.matisse.HyperLinkLabel link6;
	private scri.commons.gui.matisse.HyperLinkLabel link7;
	private scri.commons.gui.matisse.HyperLinkLabel link8;
	private scri.commons.gui.matisse.HyperLinkLabel link9;
	private javax.swing.JLabel spacerLabel;
	// End of variables declaration//GEN-END:variables

}