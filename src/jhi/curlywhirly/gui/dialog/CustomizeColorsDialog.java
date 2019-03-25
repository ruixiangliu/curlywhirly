// Copyright 2009-2019 Information & Computational Sciences, JHI. All rights
// reserved. Use is subject to the accompanying licence terms.

package jhi.curlywhirly.gui.dialog;

import jhi.curlywhirly.gui.*;
import jhi.curlywhirly.util.*;
import jhi.curlywhirly.util.ColorPrefs.*;
import scri.commons.gui.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CustomizeColorsDialog extends JDialog implements ActionListener
{
	private boolean isOK;

	public CustomizeColorsDialog()
	{
		super(
			CurlyWhirly.winMain,
			RB.getString("gui.dialog.CustomizeColorsDialog.title"),
			true
		);

		isOK = false;

		initComponents();
		initComponents2();
		getContentPane().setBackground(Color.WHITE);

		RB.setText(label, "gui.dialog.CustomizeColorsDialog.label");

		initializeList();

		list.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if (e.getClickCount() == 2)
					selectColor(list);
			}
		});

		getRootPane().setDefaultButton(bClose);
		SwingUtils.addCloseHandler(this, bClose);

		pack();
		setLocationRelativeTo(CurlyWhirly.winMain);
		setResizable(false);
		setVisible(true);
	}

	private void initComponents2()
	{
		RB.setText(bClose, "gui.text.close");
		bClose.addActionListener(this);

		RB.setText(bReset, "gui.dialog.CustomizeColorsDialog.bReset");
		bReset.addActionListener(this);
	}

	public boolean isOK()
	{
		return isOK;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == bClose)
			setVisible(false);

		else if (e.getSource() == bReset)
		{
			String msg = RB.getString("gui.dialog.CustomizeColorsDialog.confirmReset");
			String[] options = new String[]{
				RB.getString("gui.dialog.CustomizeColorsDialog.reset"),
				RB.getString("gui.text.cancel")
			};

			if (TaskDialog.show(msg, TaskDialog.QST, 1, options) != 0)
				return;

			ColorPrefs.resetUserColors();
			initializeList();
		}
	}

	void initializeList()
	{
		HashMap<String, ColorPref> colors = ColorPrefs.getColors();
		DefaultListModel<ColorPref> model = new DefaultListModel<>();

		colors.values().stream()
			.filter(v -> v.getKey().startsWith("User."))
			.sorted(Comparator.comparing(ColorPref::getKey))
			.forEach(v -> model.addElement(colors.get(v.getKey())));

		list.setModel(model);
		list.setCellRenderer(new ColorListRenderer());
	}

	private void selectColor(JList<ColorPref> list)
	{
		ColorPref cp = list.getSelectedValue();
		if (cp == null)
			return;

		Color newColor = JColorChooser.showDialog(this,
			RB.getString("gui.dialog.CustomizeColorsDialog.dialog"),
			cp.getColor());

		if (newColor == null)
			return;

		// Update the color in the list
		cp.setColor(newColor);
		// And back in the hashmap (in ColorPrefs)
		ColorPrefs.setColor(cp.getKey(), newColor);
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
		bClose = new javax.swing.JButton();
		bReset = new javax.swing.JButton();
		label = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		list = new javax.swing.JList<ColorPref>();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		bClose.setText("Close");
		dialogPanel1.add(bClose);

		bReset.setText("Reset to defaults");
		dialogPanel1.add(bReset);

		label.setText("Double click an entry to change its colour:");

		jScrollPane1.setViewportView(list);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(dialogPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
							.addComponent(label))
						.addContainerGap()))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
					.addContainerGap(293, Short.MAX_VALUE)
					.addComponent(dialogPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(label)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(54, Short.MAX_VALUE)))
		);

		pack();
	}// </editor-fold>//GEN-END:initComponents


	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton bClose;
	private javax.swing.JButton bReset;
	private scri.commons.gui.matisse.DialogPanel dialogPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel label;
	private javax.swing.JList<ColorPref> list;
	// End of variables declaration//GEN-END:variables

}