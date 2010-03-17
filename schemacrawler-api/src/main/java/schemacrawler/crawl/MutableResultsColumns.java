/* 
 *
 * SchemaCrawler
 * http://sourceforge.net/projects/schemacrawler
 * Copyright (c) 2000-2010, Sualeh Fatehi.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation;
 * either version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * library; if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA 02111-1307, USA.
 *
 */

package schemacrawler.crawl;


import java.util.Arrays;
import java.util.Iterator;

import schemacrawler.schema.ResultsColumn;
import schemacrawler.schema.ResultsColumns;

/**
 * Represents a result set, a result of a query.
 * 
 * @author Sualeh Fatehi
 */
class MutableResultsColumns
  extends AbstractNamedObject
  implements ResultsColumns
{

  private static final long serialVersionUID = 5204766782914559188L;

  private final NamedObjectList<MutableResultsColumn> columns = new NamedObjectList<MutableResultsColumn>();

  MutableResultsColumns(final String name)
  {
    super(name);
  }

  /**
   * {@inheritDoc}
   * 
   * @see schemacrawler.schema.ResultsColumns#getColumn(java.lang.String)
   */
  public ResultsColumn getColumn(final String name)
  {
    return columns.lookup(name);
  }

  /**
   * {@inheritDoc}
   * 
   * @see schemacrawler.schema.ResultsColumns#getColumns()
   */
  public ResultsColumn[] getColumns()
  {
    return columns.values().toArray(new ResultsColumn[columns.size()]);
  }

  /**
   * {@inheritDoc}
   * 
   * @see schemacrawler.schema.ResultsColumns#getColumnsListAsString()
   */
  public String getColumnsListAsString()
  {
    String columnsList = "";
    final ResultsColumn[] columnsArray = getColumns();
    if (columnsArray != null && columnsArray.length > 0)
    {
      final StringBuilder buffer = new StringBuilder();
      for (int i = 0; i < columnsArray.length; i++)
      {
        if (i > 0)
        {
          buffer.append(", ");
        }
        final ResultsColumn column = columnsArray[i];
        buffer.append(column.getFullName());
      }
      columnsList = buffer.toString();
    }
    return columnsList;
  }

  public Iterator<ResultsColumn> iterator()
  {
    return Arrays.asList(getColumns()).iterator();
  }

  void addColumn(final MutableResultsColumn column)
  {
    columns.add(column);
  }

}