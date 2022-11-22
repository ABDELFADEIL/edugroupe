package com.gescom.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.gescom.services.CLientDao;
import com.gescom.vue.ClientVue;

public class ControleurClient implements ActionListener{

	private ClientVue client;
	private CLientDao clientDao;
	

	public ControleurClient() {
		this.client = new ClientVue();
		this.clientDao = new CLientDao();
	}

	public ControleurClient(ClientVue client) {
		super();
		this.client = client;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
