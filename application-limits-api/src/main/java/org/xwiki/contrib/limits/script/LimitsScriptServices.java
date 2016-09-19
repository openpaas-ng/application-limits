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
package org.xwiki.contrib.limits.script;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.xwiki.component.annotation.Component;
import org.xwiki.contrib.limits.LimitsConfiguration;
import org.xwiki.contrib.limits.internal.users.UserCounter;
import org.xwiki.model.reference.DocumentReference;
import org.xwiki.script.service.ScriptService;

/**
 * @version $Id: $
 */
@Component
@Singleton
@Named("limits")
public class LimitsScriptServices implements ScriptService
{
    @Inject
    private LimitsConfiguration limitsConfiguration;

    @Inject
    private UserCounter userCounter;

    public int getUserLimit() throws Exception
    {
        return limitsConfiguration.getTotalNumberOfUsersLimit();
    }

    public int getWikiLimit() throws Exception
    {
        return limitsConfiguration.getWikisNumberLimit();
    }

    public int getUserCount() throws Exception
    {
        return userCounter.getUserCount();
    }

    public Map<DocumentReference, Number> getGroupLimits() throws Exception
    {
        return limitsConfiguration.getGroupsLimits();
    }

    /**
     * @since 1.2
     */
    public Map<String, Object> getCustomLimits() throws Exception
    {
        return limitsConfiguration.getCustomLimits();
    }

    public void reloadConfiguration() throws Exception
    {
        limitsConfiguration.reload();
    }

}
