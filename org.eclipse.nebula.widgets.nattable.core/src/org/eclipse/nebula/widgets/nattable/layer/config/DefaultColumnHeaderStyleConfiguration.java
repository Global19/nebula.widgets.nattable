/*******************************************************************************
 * Copyright (c) 2012, 2020 Original authors and others.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Original authors and others - initial API and implementation
 ******************************************************************************/
package org.eclipse.nebula.widgets.nattable.layer.config;

import org.eclipse.nebula.widgets.nattable.config.AbstractRegistryConfiguration;
import org.eclipse.nebula.widgets.nattable.config.CellConfigAttributes;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
import org.eclipse.nebula.widgets.nattable.painter.cell.ICellPainter;
import org.eclipse.nebula.widgets.nattable.painter.cell.TextPainter;
import org.eclipse.nebula.widgets.nattable.painter.cell.decorator.BeveledBorderDecorator;
import org.eclipse.nebula.widgets.nattable.style.BorderStyle;
import org.eclipse.nebula.widgets.nattable.style.CellStyleAttributes;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.nebula.widgets.nattable.style.HorizontalAlignmentEnum;
import org.eclipse.nebula.widgets.nattable.style.Style;
import org.eclipse.nebula.widgets.nattable.style.VerticalAlignmentEnum;
import org.eclipse.nebula.widgets.nattable.util.GUIHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;

/**
 * Sets up column header styling. Added by
 * {@link DefaultColumnHeaderLayerConfiguration}
 */
// fields are public by design to make it easy for adapters to customize styling
@SuppressWarnings("java:S1104")
public class DefaultColumnHeaderStyleConfiguration extends AbstractRegistryConfiguration {

    public Font font = GUIHelper.getFont(new FontData("Verdana", 10, SWT.NORMAL)); //$NON-NLS-1$
    public Color bgColor = GUIHelper.COLOR_WIDGET_BACKGROUND;
    public Color fgColor = GUIHelper.COLOR_WIDGET_FOREGROUND;
    public Color gradientBgColor = GUIHelper.COLOR_WHITE;
    public Color gradientFgColor = GUIHelper.getColor(136, 212, 215);
    public HorizontalAlignmentEnum hAlign = HorizontalAlignmentEnum.CENTER;
    public VerticalAlignmentEnum vAlign = VerticalAlignmentEnum.MIDDLE;
    public BorderStyle borderStyle = null;

    public ICellPainter cellPainter = new BeveledBorderDecorator(new TextPainter());

    public Boolean renderGridLines = Boolean.FALSE;

    @Override
    public void configureRegistry(IConfigRegistry configRegistry) {
        // configure the painter
        configRegistry.registerConfigAttribute(
                CellConfigAttributes.CELL_PAINTER,
                this.cellPainter,
                DisplayMode.NORMAL,
                GridRegion.COLUMN_HEADER);
        configRegistry.registerConfigAttribute(
                CellConfigAttributes.CELL_PAINTER,
                this.cellPainter,
                DisplayMode.NORMAL,
                GridRegion.CORNER);

        // configure whether to render grid lines or not
        // e.g. for the BeveledBorderDecorator the rendering of the grid lines
        // should be disabled
        configRegistry.registerConfigAttribute(
                CellConfigAttributes.RENDER_GRID_LINES,
                this.renderGridLines,
                DisplayMode.NORMAL,
                GridRegion.COLUMN_HEADER);
        configRegistry.registerConfigAttribute(
                CellConfigAttributes.RENDER_GRID_LINES,
                this.renderGridLines,
                DisplayMode.NORMAL,
                GridRegion.CORNER);

        // configure the normal style
        Style cellStyle = new Style();
        cellStyle.setAttributeValue(
                CellStyleAttributes.BACKGROUND_COLOR,
                this.bgColor);
        cellStyle.setAttributeValue(
                CellStyleAttributes.FOREGROUND_COLOR,
                this.fgColor);
        cellStyle.setAttributeValue(
                CellStyleAttributes.GRADIENT_BACKGROUND_COLOR,
                this.gradientBgColor);
        cellStyle.setAttributeValue(
                CellStyleAttributes.GRADIENT_FOREGROUND_COLOR,
                this.gradientFgColor);
        cellStyle.setAttributeValue(
                CellStyleAttributes.HORIZONTAL_ALIGNMENT,
                this.hAlign);
        cellStyle.setAttributeValue(
                CellStyleAttributes.VERTICAL_ALIGNMENT,
                this.vAlign);
        cellStyle.setAttributeValue(
                CellStyleAttributes.BORDER_STYLE,
                this.borderStyle);
        cellStyle.setAttributeValue(
                CellStyleAttributes.FONT,
                this.font);

        configRegistry.registerConfigAttribute(
                CellConfigAttributes.CELL_STYLE,
                cellStyle,
                DisplayMode.NORMAL,
                GridRegion.COLUMN_HEADER);
        configRegistry.registerConfigAttribute(
                CellConfigAttributes.CELL_STYLE,
                cellStyle,
                DisplayMode.NORMAL,
                GridRegion.CORNER);
    }
}
