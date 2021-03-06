/*******************************************************************************
 * Copyright (c) 2013, 2020 Dirk Fauth and others.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Dirk Fauth <dirk.fauth@googlemail.com> - initial API and implementation
 *******************************************************************************/
package org.eclipse.nebula.widgets.nattable.hover.command;

import org.eclipse.nebula.widgets.nattable.command.AbstractContextFreeCommand;
import org.eclipse.nebula.widgets.nattable.hover.HoverLayer;

/**
 * Command that is used to clear the hover styling in a NatTable.
 * <p>
 * This command can be used to clear every hover styling that is set in a
 * NatTable (e.g. in a grid composition there might be several HoverLayer
 * involved) or it can be used to clear the hover styling in every HoverLayer in
 * the layer composition, except the one that is set to the command.
 *
 * @author Dirk Fauth
 *
 * @see HoverLayer
 * @see ClearHoverStylingCommandHandler
 */
public class ClearHoverStylingCommand extends AbstractContextFreeCommand {

    /**
     * The HoverLayer whose hover styling should not be cleared.
     */
    private HoverLayer hoverLayer;

    /**
     * Create a ClearHoverStylingCommand that clears the hover styling in every
     * HoverLayer that exists in the layer composition.
     */
    public ClearHoverStylingCommand() {
    }

    /**
     * Create a ClearHoverStylingCommand that clears the hover styling in every
     * HoverLayer that exists in the layer composition, except the given
     * HoverLayer.
     *
     * @param hoverLayer
     *            The HoverLayer whose hover styling should not be cleared. Can
     *            be <code>null</code> which indicates that the hover styling in
     *            <b>every</b> HoverLayer in the layer composition should be
     *            cleared.
     */
    public ClearHoverStylingCommand(HoverLayer hoverLayer) {
        this.hoverLayer = hoverLayer;
    }

    /**
     * @return The HoverLayer whose hover styling should not be cleared.
     */
    public HoverLayer getHoverLayer() {
        return this.hoverLayer;
    }
}
