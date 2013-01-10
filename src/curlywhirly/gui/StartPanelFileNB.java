// Copyright 2009-2012 Information & Computational Sciences, JHI. All rights
// reserved. Use is subject to the accompanying licence terms.

package curlywhirly.gui;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import scri.commons.gui.*;
import scri.commons.gui.matisse.*;

/**
 *
 * @author gsteph
 */
public class StartPanelFileNB extends JPanel implements ActionListener
{
	private HyperLinkLabel[] labels = new HyperLinkLabel[10];

	private String[] files = new String[10];
	private String[] filenames = new String[10];
	private String[] tooltips = new String[10];

	public StartPanelFileNB()
	{
		initComponents();
		setOpaque(false);

		RB.setText(importLabel, "gui.NBStartFilePanel.importLabel");
		RB.setText(openLabel, "gui.NBStartFilePanel.openLabel");

		importLabel.setIcon(Icons.getIcon("OPEN"));
		importLabel.addActionListener(this);
		sampleLabel.setIcon(Icons.getIcon("SAMPLE"));
		sampleLabel.addActionListener(this);

		// Create the labels array
		labels[0] = project0; labels[1] = project1;
		labels[2] = project2; labels[3] = project3;
		labels[4] = project4; labels[5] = project5;
		labels[6] = project6; labels[7] = project7;
		labels[8] = project8; labels[9] = project9;


		int j=0;
		// Parse the list of recent documents
		for (final String path: Prefs.guiRecentDocs)
		{
			// Ignore any that haven't been set yet
			if (path == null || path.equals(" "))
				continue;

			File tempFile = new File(path);

			// Button text will be "name" (or "name1" | "name2")
			String text = tempFile.getName();
			String filePath = tempFile.getPath();
			String tooltip = tempFile.getPath();

			if(j < filenames.length)
			{
				filenames[j] = text;
				files[j] = filePath;
				tooltips[j] = tooltip;
			}
			else
				break;

			j++;
		}

		if (j == 0)
			openLabel.setVisible(false);

		for (int i = 0; i < labels.length; i++)
		{
			if (filenames[i] != null)
			{
				tooltips[i] = tooltips[i].replaceAll("/", "&#47;");

				labels[i].addActionListener(this);
				labels[i].setText(filenames[i]);
				labels[i].setToolTipText("<html>" + tooltips[i] + "</html>");

				labels[i].setIcon(Icons.getIcon("DOCSINGLE"));
			}
			else
				labels[i].setVisible(false);
		}
    }

	public void actionPerformed(ActionEvent e)
	{
//		WinMain wm = Tablet.winMain;
//
		if (e.getSource() == importLabel)
			CurlyWhirly.toolbar.openFile(null);

		if (e.getSource() == sampleLabel)
			CurlyWhirly.toolbar.openSample();
//
		for (int i = 0; i < labels.length; i++)
			if (e.getSource() == labels[i])
				CurlyWhirly.toolbar.openFile(new File(files[i]));
	}

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        importLabel = new scri.commons.gui.matisse.HyperLinkLabel();
        openLabel = new javax.swing.JLabel();
        sampleLabel = new scri.commons.gui.matisse.HyperLinkLabel();
        project0 = new scri.commons.gui.matisse.HyperLinkLabel();
        project1 = new scri.commons.gui.matisse.HyperLinkLabel();
        project2 = new scri.commons.gui.matisse.HyperLinkLabel();
        project3 = new scri.commons.gui.matisse.HyperLinkLabel();
        project4 = new scri.commons.gui.matisse.HyperLinkLabel();
        project5 = new scri.commons.gui.matisse.HyperLinkLabel();
        project6 = new scri.commons.gui.matisse.HyperLinkLabel();
        project7 = new scri.commons.gui.matisse.HyperLinkLabel();
        project8 = new scri.commons.gui.matisse.HyperLinkLabel();
        project9 = new scri.commons.gui.matisse.HyperLinkLabel();

        importLabel.setForeground(new java.awt.Color(68, 106, 156));
        importLabel.setText("Import data into CurlyWhirly");

        openLabel.setText("Open previously accessed files:");

        sampleLabel.setForeground(new java.awt.Color(68, 106, 156));
        sampleLabel.setText("Load sample data into CurlyWhirly");

        project0.setForeground(new java.awt.Color(68, 106, 156));
        project0.setText("<project0>");

        project1.setForeground(new java.awt.Color(68, 106, 156));
        project1.setText("<project1>");

        project2.setForeground(new java.awt.Color(68, 106, 156));
        project2.setText("<project2>");

        project3.setForeground(new java.awt.Color(68, 106, 156));
        project3.setText("<project3>");

        project4.setForeground(new java.awt.Color(68, 106, 156));
        project4.setText("<project4>");

        project5.setForeground(new java.awt.Color(68, 106, 156));
        project5.setText("<project5>");

        project6.setForeground(new java.awt.Color(68, 106, 156));
        project6.setText("<project6>");

        project7.setForeground(new java.awt.Color(68, 106, 156));
        project7.setText("<project7>");

        project8.setForeground(new java.awt.Color(68, 106, 156));
        project8.setText("<project8>");

        project9.setForeground(new java.awt.Color(68, 106, 156));
        project9.setText("<project9>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(importLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sampleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openLabel)
                    .addComponent(project0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(project1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(project2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(project3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(project4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(project5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(project6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(project7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(project8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(project9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(importLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sampleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(openLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(project0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(project1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(project2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(project3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(project4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(project5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(project6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(project7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(project8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(project9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private scri.commons.gui.matisse.HyperLinkLabel importLabel;
    private javax.swing.JLabel openLabel;
    scri.commons.gui.matisse.HyperLinkLabel project0;
    scri.commons.gui.matisse.HyperLinkLabel project1;
    scri.commons.gui.matisse.HyperLinkLabel project2;
    scri.commons.gui.matisse.HyperLinkLabel project3;
    scri.commons.gui.matisse.HyperLinkLabel project4;
    scri.commons.gui.matisse.HyperLinkLabel project5;
    scri.commons.gui.matisse.HyperLinkLabel project6;
    scri.commons.gui.matisse.HyperLinkLabel project7;
    scri.commons.gui.matisse.HyperLinkLabel project8;
    scri.commons.gui.matisse.HyperLinkLabel project9;
    scri.commons.gui.matisse.HyperLinkLabel sampleLabel;
    // End of variables declaration//GEN-END:variables

}