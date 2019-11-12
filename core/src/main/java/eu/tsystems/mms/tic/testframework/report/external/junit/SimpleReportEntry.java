/*
 * (C) Copyright T-Systems Multimedia Solutions GmbH 2018, ..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Peter Lehmann
 *     pele
 */
package eu.tsystems.mms.tic.testframework.report.external.junit;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/**
 * @author Kristian Rosenvold
 */
public class SimpleReportEntry
    implements ReportEntry
{
    private final String source;

    private final String name;

    private final StackTraceWriter stackTraceWriter;

    private final Integer elapsed;

    public SimpleReportEntry( String source, String name )
    {
        this( source, name, null, null );
    }

    public SimpleReportEntry( String source, String name, StackTraceWriter stackTraceWriter )
    {
        this( source, name, stackTraceWriter, null );
    }

    public SimpleReportEntry( String source, String name, Integer elapsed )
    {
        this( source, name, null, elapsed );
    }

    protected SimpleReportEntry( String name )
    {
        this.name = name;
        this.stackTraceWriter = null;
        this.elapsed = null;
        this.source = null;
    }


    public SimpleReportEntry(String source, String name, StackTraceWriter stackTraceWriter, Integer elapsed )
    {
        if ( source == null )
        {
            throw new NullPointerException( "source is null" );
        }
        if ( name == null )
        {
            throw new NullPointerException( "name is null" );
        }

        this.source = source;

        this.name = name;

        this.stackTraceWriter = stackTraceWriter;

        this.elapsed = elapsed;
    }


    public String getSourceName()
    {
        return source;
    }

    public String getName()
    {
        return name;
    }

    public String getGroup()
    {
        return null;
    }

    public StackTraceWriter getStackTraceWriter()
    {
        return stackTraceWriter;
    }

    public Integer getElapsed()
    {
        return elapsed;
    }

    public String toString()
    {
        return "ReportEntry{" + "source='" + source + '\'' + ", name='" + name + '\'' + ", stackTraceWriter="
            + stackTraceWriter + ", elapsed=" + elapsed + '}';
    }


    /**
     * @noinspection RedundantIfStatement
     */
    public boolean equals( Object o )
    {
        if ( this == o )
        {
            return true;
        }
        if ( o == null || getClass() != o.getClass() )
        {
            return false;
        }

        SimpleReportEntry that = (SimpleReportEntry) o;

        if ( elapsed != null ? !elapsed.equals( that.elapsed ) : that.elapsed != null )
        {
            return false;
        }
        if ( name != null ? !name.equals( that.name ) : that.name != null )
        {
            return false;
        }
        if ( source != null ? !source.equals( that.source ) : that.source != null )
        {
            return false;
        }
        if ( stackTraceWriter != null
            ? !stackTraceWriter.equals( that.stackTraceWriter )
            : that.stackTraceWriter != null )
        {
            return false;
        }

        return true;
    }

    public int hashCode()
    {
        int result = source != null ? source.hashCode() : 0;
        result = 31 * result + ( name != null ? name.hashCode() : 0 );
        result = 31 * result + ( stackTraceWriter != null ? stackTraceWriter.hashCode() : 0 );
        result = 31 * result + ( elapsed != null ? elapsed.hashCode() : 0 );
        return result;
    }


}
