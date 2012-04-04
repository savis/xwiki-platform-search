/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.platform.search.internal;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.xwiki.component.annotation.Component;
import org.xwiki.component.manager.ComponentManager;
import org.xwiki.component.phase.Initializable;
import org.xwiki.component.phase.InitializationException;
import org.xwiki.configuration.ConfigurationSource;
import org.xwiki.platform.search.SearchService;
import org.xwiki.script.service.ScriptService;

/**
 * Search Service Implementation.
 * 
 * @version $Id$
 */
@Component
@Named("search")
@Singleton
public class SearchScriptService implements ScriptService, Initializable
{
    /**
     * Logger.
     */
    @Inject
    private Logger logger;

    /**
     * Component manager.
     */
    @Inject
    private ComponentManager componentManager;

    /**
     * Search service.
     */
    private SearchService searchService;

    /**
     * Properties.
     */
    @Inject
    @Named("xwikiproperties")
    private ConfigurationSource configuration;

    /**
     * We could make the script service implement the full API defined in the SearchService interface and just have the
     * methods delegate the method calls to the underlying searchService implementation.
     * 
     * @return id of the backend.
     */

    public String getID()
    {
        return searchService.getBackend();
    }

    /**
     * Initialize the script service by retrieving the configured search backend.
     * 
     * 
     * @throws InitializationException - Exception is being thrown.
     */
    @Override
    public void initialize() throws InitializationException
    {
        String backend = configuration.getProperty("searchBackend");

        try {
            if (backend == null) {
                searchService = componentManager.lookup(SearchService.class);
            } else {
                searchService = componentManager.lookup(SearchService.class, backend);
            }

            logger.warn("Search service initialized using the {} backend", searchService.getBackend());

            // Index the documents
            searchService.indexDocuments();

        } catch (Exception e) {
            throw new InitializationException("Unable to initialize the search script service", e);
        }

    }

    /**
     * Query the documents.
     * 
     * @param query - The query to search.
     */
    public ArrayList<String> queryDocument(String query,String qfvalues)
    {
        return searchService.queryDocument(query,qfvalues);
    }
}
