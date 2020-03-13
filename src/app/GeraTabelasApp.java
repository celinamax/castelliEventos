/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import Model.CadastroSaida;
import Model.Entrada;
import java.io.File;

public class GeraTabelasApp {
    public static void main(String[] args) {
	AnnotationConfiguration cfg = new AnnotationConfiguration();
	cfg.addAnnotatedClass(CadastroSaida.class);
        cfg.addAnnotatedClass(Entrada.class);
        String hibernatePropsFilePath = "src\\app\\hibernate.cfg.xml";
        File hibernatePropsFile = new File(hibernatePropsFilePath);
        cfg.configure(hibernatePropsFile);
	new SchemaExport(cfg).create(true,true);
    }
}
