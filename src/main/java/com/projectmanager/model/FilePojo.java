package com.projectmanager.model;

import java.io.File;
import java.util.Date;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component

public class FilePojo {

    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public FilePojo(File file) {
	super();
	this.file = file;
    }
    
    public FilePojo()
    {	
    }
    
	public void testSchedule()
	{
		System.out.println(new Date().toString());
	}
}
