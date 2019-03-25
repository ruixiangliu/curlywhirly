// Copyright 2009-2019 Information & Computational Sciences, JHI. All rights
// reserved. Use is subject to the accompanying licence terms.

package jhi.curlywhirly.gui.dialog;

import jhi.curlywhirly.gui.*;
import jhi.curlywhirly.util.*;
import scri.commons.gui.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class ExportScreenshotDialog extends JDialog implements ActionListener
{
	private boolean isOK;
	private final WinMain winMain;

	private ButtonGroup group;
	private BufferedImage image;

	public ExportScreenshotDialog(WinMain winMain)
	{
		super(
			CurlyWhirly.winMain,
			RB.getString("gui.dialog.ExportScreenshotDialog.title"),
			true
		);

		this.winMain = winMain;

		isOK = false;

		try
		{
			image = winMain.getOpenGLPanel().getScreenShot(false);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		initComponents();
		initComponents2();
		getContentPane().setBackground(Color.WHITE);

		getRootPane().setDefaultButton(bOK);
		SwingUtils.addCloseHandler(this, bOK);

		pack();
		setLocationRelativeTo(CurlyWhirly.winMain);
		setResizable(false);
		setVisible(true);
	}

	private void initComponents2()
	{
		RB.setText(bOK, "gui.text.ok");
		bOK.addActionListener(this);

		RB.setText(bCancel, "gui.text.cancel");
		bCancel.addActionListener(this);

		settingsPanel.setBorder(new TitledBorder(RB.getString("gui.dialog.ExportScreenshotDialog.settingsPanel.title")));
		RB.setText(filenameLabel, "gui.dialog.ExportScreenshotDialog.fileNameLabel");

		RB.setText(bBrowse, "gui.text.browse");
		bBrowse.addActionListener(this);

		RB.setText(btnKey, "gui.dialog.ExportScreenshotDialog.btnKey");
		btnKey.addActionListener(this);

		RB.setText(btnScene, "gui.dialog.ExportScreenshotDialog.btnScene");
		btnScene.addActionListener(this);

		RB.setText(btnSceneWithKey, "gui.dialog.ExportScreenshotDialog.btnSceneWithKey");
		btnSceneWithKey.addActionListener(this);

		group = new ButtonGroup();
		group.add(btnKey);
		group.add(btnScene);
		group.add(btnSceneWithKey);

		btnScene.setSelected(true);

		filenameTextField.setText(Prefs.guiCurrentDir + System.getProperty("file.separator")
			+ winMain.getDataSet().getName() + RB.getString("gui.ExportScreenshotDialog.fileExtension"));

		settingsPanel.setBackground(Color.WHITE);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == bOK)
		{
			isOK = true;
			setVisible(false);
		}

		else if (e.getSource() == bCancel)
			setVisible(false);

		else if (e.getSource() == bBrowse)
		{
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
				RB.getString("other.Filters.png"), RB.getString("gui.ExportScreenshotDialog.fileExtension"));
			String filename = FileUtils.getSaveFilename(RB.getString("gui.dialog.ExportScreenshotDialog.saveAs"), null, filter);
			if (filename != null)
				filenameTextField.setText(filename);
		}

		else if (e.getSource() == btnKey)
		{
			image = winMain.getColourKeyCreator().getColourKeyImage();
		}

		else if (e.getSource() == btnScene)
		{
			try
			{
				image = winMain.getOpenGLPanel().getScreenShot(false);
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}

		else if (e.getSource() == btnSceneWithKey)
		{
			try
			{
				image = winMain.getOpenGLPanel().getScreenShot(true);
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}

	public String getFilename()
	{
		return filenameTextField.getText();
	}

	public boolean isOk()
	{
		return isOK;
	}

	public BufferedImage getImage()
	{
		return image;
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

		dialogPanel1 = new scri.commons.gui.matisse.DialogPanel();
		bOK = new javax.swing.JButton();
		bCancel = new javax.swing.JButton();
		settingsPanel = new javax.swing.JPanel();
		filenameLabel = new javax.swing.JLabel();
		bBrowse = new javax.swing.JButton();
		filenameTextField = new javax.swing.JTextField();
		btnScene = new javax.swing.JRadioButton();
		btnSceneWithKey = new javax.swing.JRadioButton();
		btnKey = new javax.swing.JRadioButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		bOK.setText("OK");
		dialogPanel1.add(bOK);

		bCancel.setText("Cancel");
		dialogPanel1.add(bCancel);

		settingsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Screenshot settings:"));

		filenameLabel.setText("Filename:");

		bBrowse.setText("Browse...");

		filenameTextField.setText("C:\\Users\\blah\\dataset.avi");

		btnScene.setText("Screenshot of scene");

		btnSceneWithKey.setText("Screenshot of scene with colour key");

		btnKey.setText("Standalone colour key");

		javax.swing.GroupLayout settingsPanelLayout = new javax.swing.GroupLayout(settingsPanel);
		settingsPanel.setLayout(settingsPanelLayout);
		settingsPanelLayout.setHorizontalGroup(
			settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(settingsPanelLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(settingsPanelLayout.createSequentialGroup()
							.addComponent(filenameLabel)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(filenameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(bBrowse))
						.addGroup(settingsPanelLayout.createSequentialGroup()
							.addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(btnSceneWithKey)
								.addComponent(btnScene)
								.addComponent(btnKey))
							.addGap(0, 0, Short.MAX_VALUE)))
					.addContainerGap())
		);
		settingsPanelLayout.setVerticalGroup(
			settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingsPanelLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnScene)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(btnSceneWithKey, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(btnKey)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(filenameLabel)
						.addComponent(bBrowse)
						.addComponent(filenameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(dialogPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(settingsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(settingsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(dialogPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		);

		pack();
	}// </editor-fold>//GEN-END:initComponents


	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton bBrowse;
	private javax.swing.JButton bCancel;
	private javax.swing.JButton bOK;
	private javax.swing.JRadioButton btnKey;
	private javax.swing.JRadioButton btnScene;
	private javax.swing.JRadioButton btnSceneWithKey;
	private scri.commons.gui.matisse.DialogPanel dialogPanel1;
	private javax.swing.JLabel filenameLabel;
	private javax.swing.JTextField filenameTextField;
	private javax.swing.JPanel settingsPanel;
	// End of variables declaration//GEN-END:variables

}