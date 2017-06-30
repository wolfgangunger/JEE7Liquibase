/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unw.lb.business.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.sql.DataSource;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.resource.ResourceAccessor;

/**
 *
 * @author UNGERW
 */
@Startup
@Singleton
@TransactionManagement(TransactionManagementType.BEAN)
public class LiquibaseStartBean {

    private static final String STAGE = "development";
    private static final String CHANGELOG_FILE = "liquibase/db.changelog-master.xml";

    private final Logger logger = Logger.getLogger(LiquibaseStartBean.class.getName());

    @Resource(mappedName = "jdbc/lb")
    private DataSource ds;


    @PostConstruct
    public void executeLiquibase() {
        logger.info("######### Starting Liquibase");
        ResourceAccessor resourceAccessor = new ClassLoaderResourceAccessor(getClass().getClassLoader());
        try (Connection connection = ds.getConnection()) {
            JdbcConnection jdbcConnection = new JdbcConnection(connection);
            Database db = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(jdbcConnection);
            Liquibase liquiBase = new Liquibase(CHANGELOG_FILE, resourceAccessor, db);
            liquiBase.update(STAGE);
        } catch (SQLException | LiquibaseException e) {
            logger.warning(e.getMessage());
        }

    }
}
