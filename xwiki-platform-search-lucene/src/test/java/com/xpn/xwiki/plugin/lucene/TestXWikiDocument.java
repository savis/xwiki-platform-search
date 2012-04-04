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
package com.xpn.xwiki.plugin.lucene;

import org.xwiki.model.reference.DocumentReference;
import org.xwiki.rendering.syntax.Syntax;

import com.xpn.xwiki.XWikiContext;
import com.xpn.xwiki.XWikiException;
import com.xpn.xwiki.doc.XWikiDocument;

/**
 * @version $Id: 7c23f9b324ea7c699b602c536b765a8a9a3363c9 $
 */
public class TestXWikiDocument extends XWikiDocument
{
    public TestXWikiDocument(DocumentReference documentReference)
    {
        super(documentReference);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.xpn.xwiki.doc.XWikiDocument#getTranslatedDocument(java.lang.String, com.xpn.xwiki.XWikiContext)
     */
    @Override
    public XWikiDocument getTranslatedDocument(String language, XWikiContext context) throws XWikiException
    {
        return this;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.xpn.xwiki.doc.XWikiDocument#getRenderedTitle(org.xwiki.rendering.syntax.Syntax,
     *      com.xpn.xwiki.XWikiContext)
     */
    @Override
    public String getRenderedTitle(Syntax outputSyntax, XWikiContext context)
    {
        return getTitle();
    }
}
