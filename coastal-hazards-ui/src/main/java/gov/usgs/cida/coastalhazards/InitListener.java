package gov.usgs.cida.coastalhazards;

import gov.usgs.cida.config.DynamicReadOnlyProperties;
import gov.usgs.cida.utilities.communication.UploadHandlerServlet;
import gov.usgs.cida.utilities.properties.JNDISingleton;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;

/**
 * Web application lifecycle listener.
 *
 * @author isuftin
 */
public class InitListener implements ServletContextListener {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(UploadHandlerServlet.class);
    private static DynamicReadOnlyProperties props = null;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        props = JNDISingleton.getInstance();
        LOG.info("Coastal Hazards UI Application Initializing.");

        String baseDir = props.getProperty("coastal-hazards.files.directory.base", FileUtils.getTempDirectoryPath() + "/coastal-hazards");
        String workDir = props.getProperty("coastal-hazards.files.directory.work", "/work");
        String uploadDir = props.getProperty("coastal-hazards.files.directory.upload", "/upload");
        File baseDirFile, workDirFile, uploadDirFile;

        System.setProperty("coastal-hazards.files.directory.base", baseDir);
        System.setProperty("coastal-hazards.files.directory.work", workDir);
        System.setProperty("coastal-hazards.files.directory.upload", uploadDir);

        baseDirFile = new File(baseDir);
        workDirFile = new File(baseDirFile, workDir);
        uploadDirFile = new File(baseDirFile, uploadDir);

        if (!baseDirFile.exists()) {
            createDir(baseDirFile);
        }

        if (!workDirFile.exists()) {
            createDir(workDirFile);
        }
        
        if (!uploadDirFile.exists()) {
            createDir(uploadDirFile);
        }
        
        // TODO- Create file cleanup service for work directory

        LOG.info("Coastal Hazards UI Application Initialized.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOG.info("Coastal Hazards UI Application Destroying.");
        LOG.info("Coastal Hazards UI Application Destroyed.");
    }

    private void createDir(File directory) {
        try {
            FileUtils.forceMkdir(directory);
        } catch (IOException ex) {
            LOG.error("** Work application directory (" + directory.getPath() + ") could not be created -- the application should not be expected to function normally", ex);
        }
    }
}
