/*
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.planner.config.heuristic.selector.move;

import org.drools.planner.config.EnvironmentMode;
import org.drools.planner.config.heuristic.selector.SelectorConfig;
import org.drools.planner.config.heuristic.selector.common.SelectionOrder;
import org.drools.planner.config.heuristic.selector.move.generic.ChangeMoveSelectorConfig;
import org.drools.planner.core.domain.solution.SolutionDescriptor;
import org.drools.planner.core.heuristic.selector.move.MoveSelector;

/**
 * General superclass for {@link ChangeMoveSelectorConfig}, etc.
 */
public abstract class MoveSelectorConfig extends SelectorConfig {

    private Double fixedProbabilityWeight = null;

    public Double getFixedProbabilityWeight() {
        return fixedProbabilityWeight;
    }

    public void setFixedProbabilityWeight(Double fixedProbabilityWeight) {
        this.fixedProbabilityWeight = fixedProbabilityWeight;
    }

    // ************************************************************************
    // Builder methods
    // ************************************************************************

    public abstract MoveSelector buildMoveSelector(EnvironmentMode environmentMode,
            SolutionDescriptor solutionDescriptor, SelectionOrder inheritedResolvedSelectionOrder);

    protected void inherit(MoveSelectorConfig inheritedConfig) {
        super.inherit(inheritedConfig);
        if (fixedProbabilityWeight == null) {
            fixedProbabilityWeight = inheritedConfig.getFixedProbabilityWeight();
        }
    }

}
