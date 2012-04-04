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
package org.xwiki.platform.search.solr.internal;

/**
 * Solr Index fields.
 * 
 * @version $Id$
 */
public interface IndexFields
{

    /**
     * Keyword field, holds the name of the virtual wiki a document belongs to.
     */
    String DOCUMENT_WIKI = "wiki";

    /**
     * Title of the document.
     */
    String DOCUMENT_TITLE = "title";

    /**
     * Name of the document.
     */
    String DOCUMENT_NAME = "name";

    /**
     * Name of the space the document belongs to.
     */
    String DOCUMENT_SPACE = "space";

    /**
     * FullName of the document (example : Main.WebHome).
     */
    String DOCUMENT_FULLNAME = "fullname";

    /**
     * Version of the document.
     */
    String DOCUMENT_VERSION = "version";

    /**
     * Language of the document.
     */
    String DOCUMENT_LANGUAGE = "lang";

    /**
     * Type of a document, "attachment", "wikipage" or "objects", used to control presentation of searchresults.
     */
    String DOCUMENT_TYPE = "type";

    /**
     * Filename, only used for attachments.
     */
    String FILENAME = "filename";

    /**
     * XWiki object type, only used for objects.
     */
    String OBJECT = "object";

    /**
     * Last modifier.
     */
    String DOCUMENT_AUTHOR = "author";

    /**
     * Creator of the document.
     */
    String DOCUMENT_CREATOR = "creator";

    /**
     * Date of last modification.
     */
    String DOCUMENT_DATE = "date";

    /**
     * Date of creation.
     */
    String DOCUMENT_CREATIONDATE = "creationdate";

    /**
     * Fulltext content, not stored (and can therefore not be restored from the index).
     */
    String FULLTEXT = "ft";

    /**
     * not in use.
     */
    String KEYWORDS = "kw";

    /**
     * Format for date storage in the index, and therefore the format which has to be used for date-queries.
     */
    String DATE_FORMAT = "yyyyMMddHHmm";

}
