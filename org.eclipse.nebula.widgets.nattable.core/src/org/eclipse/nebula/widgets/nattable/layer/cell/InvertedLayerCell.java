/*******************************************************************************
 * Copyright (c) 2012, 2020 Edwin Park and others.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Edwin Park - initial API and implementation
 ******************************************************************************/
package org.eclipse.nebula.widgets.nattable.layer.cell;

import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.eclipse.nebula.widgets.nattable.layer.InvertUtil;
import org.eclipse.nebula.widgets.nattable.layer.LabelStack;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.swt.graphics.Rectangle;

public class InvertedLayerCell implements ILayerCell {

    private final ILayerCell layerCell;

    public InvertedLayerCell(ILayerCell layerCell) {
        this.layerCell = layerCell;
    }

    @Override
    public int getOriginColumnPosition() {
        return this.layerCell.getOriginRowPosition();
    }

    @Override
    public int getOriginRowPosition() {
        return this.layerCell.getOriginColumnPosition();
    }

    @Override
    public ILayer getLayer() {
        return this.layerCell.getLayer();
    }

    @Override
    public int getColumnPosition() {
        return this.layerCell.getRowPosition();
    }

    @Override
    public int getRowPosition() {
        return this.layerCell.getColumnPosition();
    }

    @Override
    public int getColumnIndex() {
        return this.layerCell.getRowIndex();
    }

    @Override
    public int getRowIndex() {
        return this.layerCell.getColumnIndex();
    }

    @Override
    public int getColumnSpan() {
        return this.layerCell.getRowSpan();
    }

    @Override
    public int getRowSpan() {
        return this.layerCell.getColumnSpan();
    }

    @Override
    public boolean isSpannedCell() {
        return this.layerCell.isSpannedCell();
    }

    @Override
    public DisplayMode getDisplayMode() {
        return this.layerCell.getDisplayMode();
    }

    @Override
    public LabelStack getConfigLabels() {
        return this.layerCell.getConfigLabels();
    }

    @Override
    public Object getDataValue() {
        return this.layerCell.getDataValue();
    }

    @Override
    public Rectangle getBounds() {
        return InvertUtil.invertRectangle(this.layerCell.getBounds());
    }

}
